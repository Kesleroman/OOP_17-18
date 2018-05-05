package kruzok;

import gui.HlavnaScena;
import ludia.HracVSach;
import ludia.Ucitel;
import udalosti.PriebehTurnaju;

public aspect SkupinaObserver {
	Kruzok kruzok = HlavnaScena.getKruzok();
	
	public void Skupina.upovedomPozorovatela(){
		this.getUcitel().obnovit();
	}
	
	public void HracVSach.zvysitUroven(){
		this.getUroven().zvysitUroven(this);
	}
	
	public void Ucitel.obnovit(){
		Skupina skupina = this.getSkupina();
		for(CastKruzku hrac : skupina) {
			int rating = ((HracVSach) hrac).getRating(),
				maxRating = ((HracVSach) hrac).getUroven().MAX_Rating;
			
			if(rating > maxRating) {
				((HracVSach) hrac).zvysitUroven();
			}
		} 
	}
	
	after(): execution(* PriebehTurnaju+.celyTurnaj(..)) || execution(* Kruzok.cvicenie(..)){
		Skupina ucitelia = kruzok.getUcitelia();
		
		for(CastKruzku ucitel : ucitelia) {
			((Ucitel) ucitel).obnovit();
		}
	}
	
	after(HracVSach hrac1, HracVSach hrac2): execution(* PriebehTurnaju.zmenitRating(..)) && args(hrac1, hrac2, double){
		if(hrac1.getRating() < 0) {
			hrac1.setRating(0);
		}
		
		if(hrac2.getRating() < 0) {
			hrac2.setRating(0);
		}
	}
}
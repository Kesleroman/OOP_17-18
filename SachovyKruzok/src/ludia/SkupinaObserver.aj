package ludia;

import gui.HlavnaScena;
import kruzok.CastKruzku;
import kruzok.Kruzok;
import kruzok.Skupina;
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
}
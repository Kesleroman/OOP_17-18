package udalosti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import ludia.HracVSach;

public class PriebehTurnaju {
	
	private Turnaj turnaj;
	private ArrayList<ArrayList<HracVSach>> skupiny;
	private final int HRACOV_V_SKUPINE = 8;
	private final int pocetSkupin;
	
	public PriebehTurnaju(Turnaj turnaj) {
		this.turnaj = turnaj;
		pocetSkupin = turnaj.ucastnici.size() / HRACOV_V_SKUPINE + 1; // 1 skupina ma 8 hracov.
	}
	
	public String toString() {
		String str = new String();
		
		for(HracVSach hrac : turnaj.ucastnici) {
			str = str.concat(hrac.toString() + "\n");
		}
		
		return str;
	}
	
	public void sortovanie() {
		turnaj.ucastnici.sort( (hrac1, hrac2) ->
				 Integer.compare(hrac2.getRating(), hrac1.getRating())
		);
	}
	
	public void vytvoritSkupiny() {
		skupiny = new ArrayList<>(pocetSkupin);
		for(int i = 0; i < pocetSkupin; ++i) {
			skupiny.add( new ArrayList<HracVSach>(HRACOV_V_SKUPINE) ) ;
		}
		
		int skupina = 0, i = 0;
		for(HracVSach hrac: turnaj.ucastnici) {
			skupiny.get(skupina).add(hrac);
			
			if(i == 7) {
				skupina++;
				i = 0;
				continue;
			}
			i++;
		}
	}
	
	public void vytvoritPary() {
		for(ArrayList<HracVSach> arr: skupiny) {
			Collections.shuffle(arr);
		}
	}
	
	public double strednaHodnota(int ratingA, int ratingB) {
		return 1/(1 + Math.abs(ratingA-ratingB)/40);
	}
	
	public void hra1na1(HracVSach hrac1, HracVSach hrac2){
		Random rnd = new Random();
		int sancaVyhry = 50 + (hrac1.getRating() - hrac2.getRating())/10;
		int r = rnd.nextInt(101);
		
		if(r < sancaVyhry) {
			zvysitRating(hrac1, hrac2, 1); // 1. vyhrava
		}else if(r > sancaVyhry) {
			zvysitRating(hrac1, hrac2, -1); // 2. vyhrava
		}else
			zvysitRating(hrac1, hrac2, 0); // remiza
	}
	
	public void zvysitRating(HracVSach hrac1, HracVSach hrac2, int vysledok) {
		int koeficient1 = hrac1.getRating() >= 2400 ? 10 : 20,
			koeficient2 = hrac2.getRating() >= 2400 ? 10 : 20,
			novyRating1, novyRating2;
		double strednaHodnota = strednaHodnota(hrac1.getRating(), hrac2.getRating());
			
		switch(vysledok) {
			case 1: {
				novyRating1 = hrac1.getRating() + (int)(koeficient1 * (1 - strednaHodnota));
				novyRating2 = hrac2.getRating() + (int)(koeficient2 * (0 - strednaHodnota));
				break;
			}
			case -1: {
				novyRating1 = hrac1.getRating() + (int)(koeficient1 * (0 - strednaHodnota));
				novyRating2 = hrac2.getRating() + (int)(koeficient2 * (1 - strednaHodnota));
				break;
			}
			default: 
				novyRating1 = hrac1.getRating() + (int)(koeficient1 * (0.5 - strednaHodnota));
				novyRating2 = hrac2.getRating() + (int)(koeficient2 * (0.5 - strednaHodnota));
		}
		hrac1.setRating(novyRating1);
		hrac2.setRating(novyRating2);
	}
	
	public void hra() {
		for(ArrayList<HracVSach> skupina: skupiny) {
			Iterator<HracVSach> i = skupina.iterator();
			HracVSach hrac1, hrac2;
			while(i.hasNext()) {
				 hrac1 = i.next();
				 hrac2 = i.next();// TODO: Ak je neparny pocet hracov 
				 hra1na1(hrac1, hrac2);
			}
			
		}
	}
}
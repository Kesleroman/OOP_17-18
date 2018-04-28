package udalosti;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Random;

import ludia.HracVSach;

public class PriebehTurnaju {
	private Turnaj turnaj;
	private ArrayList<ArrayList<HracVSach>> skupiny;
	private ArrayList<ArrayList<Object>> vysledky;
	private final int HRACOV_V_SKUPINE = 8,
					  POCET_SKUPIN,
					  POCET_KOL;
	private final double VYHRA = 1,
		  	 			 PREHRA = 0,
		  	 			 REMIZA = 0.5;
	
	public PriebehTurnaju(Turnaj turnaj) {
		this.turnaj = turnaj;
		this.POCET_KOL = 10;
		POCET_SKUPIN = (int)Math.ceil((double)turnaj.ucastnici.size() / HRACOV_V_SKUPINE);
		
		vytvoritPoleVysledkov();
	}
	
	public PriebehTurnaju(Turnaj turnaj, int pocetKol) {
		this.turnaj = turnaj;
		this.POCET_KOL = pocetKol;
		POCET_SKUPIN = (int)Math.ceil((double)turnaj.ucastnici.size() / HRACOV_V_SKUPINE);
	
		vytvoritPoleVysledkov();
	}
	
	private void vytvoritPoleVysledkov() {
		vysledky = new ArrayList<ArrayList<Object>>();
		
		for(HracVSach hrac : turnaj.ucastnici) {
			ArrayList<Object> arr = new ArrayList<Object>();
			arr.add(hrac); 
			arr.add(new Double(0)); 
			vysledky.add(arr);
		}
	}
	
	public String toString() {
		String str = new String();
		
		for(HracVSach hrac : turnaj.ucastnici) {
			str = str.concat(hrac.toString() + "\n");
		}
		
		return str;
	}
	
	private static class HracComparator{
		public static int compare(HracVSach hrac1, HracVSach hrac2) {
			return Integer.compare(hrac2.getRating(), hrac1.getRating());
		}
	}
	
	public void sortovanie() {
		turnaj.ucastnici.sort(HracComparator::compare); //Na prvom mieste v poli bude hrac s najvyssim ratingom.
	}
	
	public void vytvoritSkupiny() {
		skupiny = new ArrayList<>(POCET_SKUPIN);
		for(int i = 0; i < POCET_SKUPIN; ++i) {
			skupiny.add( new ArrayList<HracVSach>(HRACOV_V_SKUPINE) ) ;
		}
		
		int skupina = 0, i = 1;
		for(HracVSach hrac: turnaj.ucastnici) {
			skupiny.get(skupina).add(hrac);
			
			if(i == HRACOV_V_SKUPINE) {
				skupina++;
				i = 1;
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
	
	private void zapisatDoVysledkov(Object hrac1, Object hrac2, double vysledok) {
		if(vysledok == VYHRA){
				for(ArrayList<Object> arr : vysledky) {
					if(arr.contains(hrac1)) {
						double val = ((Double) arr.get(1)).doubleValue();
						arr.set(1, new Double(val + VYHRA)); //zvysit
						break;
					}
				}
			}
		else if(vysledok == PREHRA){
				for(ArrayList<Object> arr : vysledky) {
					if(arr.contains(hrac2)) {
						double val = ((Double) arr.get(1)).doubleValue();
						arr.set(1, new Double(val + VYHRA));
						break;
					}
				}
			}
		else{
			for(ArrayList<Object> arr : vysledky) {
				if(arr.contains(hrac1)) {
					double val = ((Double) arr.get(1)).doubleValue();
					arr.set(1, new Double(val + REMIZA));
				}
				
				if(arr.contains(hrac2)) {
					double val = ((Double) arr.get(1)).doubleValue();
					arr.set(1, new Double(val + REMIZA));
				}
			}
		}
	}
	
	
	/*
	 * Vrati koeficient poctu bodov, ktory ziska hrac s ratingom 'ratingA'.
	 * Interval navratovej hodnoty: (0 ; 1).
	 */
	private double ocakavanyPocetBodov(int ratingA, int ratingB) {
		return 1 / (1 + Math.pow(10, ((double) (ratingB-ratingA)) / 400));
	}
	
	private void zmenitRating(HracVSach hrac1, HracVSach hrac2, double vysledok) {
		int pocetBodov1 = hrac1.getRating() >= 2400 ? 10 : 20,
			pocetBodov2 = hrac2.getRating() >= 2400 ? 10 : 20,
			novyRating1, novyRating2;
		double ocakavanyPocetBodov = ocakavanyPocetBodov(hrac1.getRating(), hrac2.getRating());
			
		if(vysledok == VYHRA){
				novyRating1 = hrac1.getRating() + (int)((double)pocetBodov1 * (VYHRA - ocakavanyPocetBodov));
				novyRating2 = hrac2.getRating() + (int)((double)pocetBodov2 * (PREHRA - ocakavanyPocetBodov));
			}
		else if(vysledok == PREHRA){
				novyRating1 = hrac1.getRating() + (int)((double)pocetBodov1 * (PREHRA - ocakavanyPocetBodov));
				novyRating2 = hrac2.getRating() + (int)((double)pocetBodov2 * (VYHRA - ocakavanyPocetBodov));
			}
		else { 
				novyRating1 = hrac1.getRating() + (int)((double)pocetBodov1 * (REMIZA - ocakavanyPocetBodov));
				novyRating2 = hrac2.getRating() + (int)((double)pocetBodov2 * (REMIZA - ocakavanyPocetBodov));
		}
		hrac1.setRating(novyRating1);
		hrac2.setRating(novyRating2);
	}
	
	private void hra1na1(HracVSach hrac1, HracVSach hrac2){
		Random rnd = new Random();
		int sancaVyhry =(int) (100 * ocakavanyPocetBodov(hrac1.getRating(), hrac2.getRating()));
		int r = rnd.nextInt(101);
		
		if(r < sancaVyhry) {
			zapisatDoVysledkov(hrac1, hrac2, VYHRA); // 1. vyhrava
			zmenitRating(hrac1, hrac2, VYHRA); 
		}else if(r > sancaVyhry) {
			zapisatDoVysledkov(hrac1, hrac2, PREHRA); // 2. vyhrava
			zmenitRating(hrac1, hrac2, PREHRA); 
		}else {
			zapisatDoVysledkov(hrac1, hrac2, REMIZA);
			zmenitRating(hrac1, hrac2, REMIZA); 
		}
	}
	
	public void hra() {
		for(ArrayList<HracVSach> skupina: skupiny) {
			Iterator<HracVSach> i = skupina.iterator();
			HracVSach hrac1, hrac2;
			while(i.hasNext()) {
				 hrac1 = i.next();
				 if(i.hasNext()){
					 hrac2 = i.next(); 
					 hra1na1(hrac1, hrac2);
				 }
				 else
					 zapisatDoVysledkov(hrac1, null, 1); // ak nie je par, tak hrac ziskava bod.
			}
		}
	}
	
	public String vysledky() {
		String str = new String();
		
		vysledky.sort(new Comparator<ArrayList<Object>>() {

			public int compare(ArrayList<Object> o1, ArrayList<Object> o2) {
				double vysledok1 = ((Double) o1.get(1)),
					   vysledok2 = ((Double) o2.get(1));
				
				return Double.compare(vysledok2, vysledok1);
			}
			
		});
		
		for(ArrayList<Object> arr : vysledky) {
			str = str.concat(arr.get(0).toString() + " Body: " + arr.get(1).toString() + "\n");
		}
		
		return str;
	}
	
	public void celyTurnaj() {
		for(int kolo = 0; kolo < POCET_KOL; ++kolo) {
			sortovanie();
			vytvoritSkupiny();
			vytvoritPary();
			hra();
		}
		sortovanie();
		
		if(turnaj instanceof LokalnyTurnajPrePokrocilych) {
			((LokalnyTurnajPrePokrocilych) turnaj).povolitSaZucastnitVETurnaji(); //TODO zmenit
		}
	}
}
package urovne;

import ludia.HracVSach;

public class Majster extends Uroven {
	private final static int MIN_Rating = 2000;

	public Majster(int rating) {
		super(rating);
		setMAX(Integer.MAX_VALUE);
	}
	
	public Majster() {
		super(MIN_Rating);
		setMAX(Integer.MAX_VALUE);
	}

	public String toString() {
		return "Majster";
	}
	
	public void zvysitUroven(HracVSach hrac) { /* ... */ } // Nie je vacsia Uroven.
}
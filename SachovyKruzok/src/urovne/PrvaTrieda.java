package urovne;

import ludia.HracVSach;

public class PrvaTrieda extends Uroven {
	public final static int MIN_Rating = 1800;
	
	public PrvaTrieda(int rating) {
		super(rating);
		MAX_Rating = 1999;
	}
	
	public PrvaTrieda() {
		super(MIN_Rating);
		MAX_Rating = 1999;
	}

	public String toString() {
		return "Prva Trieda";
	}
	
	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new Majster(this.rating));
	}
}

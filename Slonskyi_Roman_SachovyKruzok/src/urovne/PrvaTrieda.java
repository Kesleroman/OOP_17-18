package urovne;

import ludia.HracVSach;

public class PrvaTrieda extends Uroven {
	private final static int MIN_Rating = 1800;
	
	public PrvaTrieda(int rating) {
		super(rating);
		setMAX(1999);
	}
	
	public PrvaTrieda() {
		super(MIN_Rating);
		setMAX(1999);
	}

	public String toString() {
		return "Prva Trieda";
	}
	
	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new Majster(this.getRating()));
	}
}

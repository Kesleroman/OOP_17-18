package urovne;

import ludia.HracVSach;

public class DruhaTrieda extends Uroven{
	public final static int MIN_Rating = 1600;

	public DruhaTrieda(int rating) {
		super(rating);
		MAX_Rating = 1799;
	}
	
	public DruhaTrieda() {
		super(MIN_Rating);
		MAX_Rating = 1799;
	}

	public String toString() {
		return "Druha Trieda";
	}
	
	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new PrvaTrieda(this.rating));
	}
}

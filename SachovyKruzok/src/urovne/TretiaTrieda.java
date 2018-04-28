package urovne;

import ludia.HracVSach;

public class TretiaTrieda extends Uroven {
	public final static int MIN_Rating = 1400;
	
	public TretiaTrieda(int rating) {
		super(rating);
		MAX_Rating = 1599;
	}
	
	public TretiaTrieda() {
		super(MIN_Rating);
		MAX_Rating = 1599;
	}

	public String toString() {
		return "Tretia Trieda";
	}
	
	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new DruhaTrieda(this.rating));
	}
}

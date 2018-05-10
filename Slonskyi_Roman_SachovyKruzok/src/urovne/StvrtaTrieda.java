package urovne;

import ludia.HracVSach;

public class StvrtaTrieda extends Uroven {
	public final static int MIN_Rating = 1000;
	
	public StvrtaTrieda(int rating) {
		super(rating);
		MAX_Rating = 1399;
	}
	
	public StvrtaTrieda() {
		super(MIN_Rating);
		MAX_Rating = 1399;
	}

	public String toString() {
		return "Stvrta Trieda";
	}
	
	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new TretiaTrieda(this.rating));
	}
}

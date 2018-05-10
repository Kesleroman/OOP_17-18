package urovne;

import ludia.HracVSach;

public class Novacik extends Uroven {
	public final static int MIN_Rating = 0;
	
	public Novacik(int rating) {
		super(rating);
		MAX_Rating = 999;
	}
	
	public Novacik() {
		super(MIN_Rating);
		MAX_Rating = 999;
	}

	public String toString() {
		return "Novacik";
	}

	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new StvrtaTrieda(this.rating));
	}
}

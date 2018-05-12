package urovne;

import ludia.HracVSach;

public class Novacik extends Uroven {
	private final static int MIN_Rating = 0;
	
	public Novacik(int rating) {
		super(rating);
		setMAX(999);
	}
	
	public Novacik() {
		super(MIN_Rating);
		setMAX(999);
	}

	public String toString() {
		return "Novacik";
	}

	public void zvysitUroven(HracVSach hrac) {
		hrac.setUroven(new StvrtaTrieda(this.getRating()));
	}
}

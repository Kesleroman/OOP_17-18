package urovne;

import ludia.HracVSach;

public abstract class Uroven implements Comparable<Uroven>{
	public int MAX_Rating ;
	
	protected int rating;
	
	public Uroven(int rating){
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public abstract void zvysitUroven(HracVSach hrac);
	public abstract String toString();
	
	public int compareTo(Uroven u) {
		return this.rating > u.getRating() ? 1 : this.rating < u.getRating() ? -1 : 0 ;
	}
}
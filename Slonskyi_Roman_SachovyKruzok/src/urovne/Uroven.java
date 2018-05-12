package urovne;

import ludia.HracVSach;

public abstract class Uroven implements Comparable<Uroven>{
	private int MAX_Rating ;
	private int rating;
	
	public Uroven(int rating){
		this.rating = rating;
	}
	
	public int getMAX(){
		return MAX_Rating;	
	}
	
	public int setMAX(int value){
		return MAX_Rating;
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
package urovne;

public abstract class Uroven implements Comparable<Uroven>{
	private int rating;
	
	public Uroven(int rating){
		this.rating = rating;
	}
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public abstract String toString();
	
	public int compareTo(Uroven u) {
		return this.rating > u.getRating() ? 1 : this.rating < u.getRating() ? -1 : 0 ;
	}
}
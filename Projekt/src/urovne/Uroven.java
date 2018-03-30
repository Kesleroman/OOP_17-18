package urovne;

public abstract class Uroven {
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
	
}

package udalosti;

public class PriebehTurnaju {
	
	private Turnaj turnaj;
	
	public PriebehTurnaju(Turnaj turnaj) {
		this.turnaj = turnaj;
	}
	
	public void sortovanie() {
		turnaj.ucastnici.sort( (hrac1, hrac2) ->
				 Integer.compare(hrac1.getRating(), hrac2.getRating())
		);
	}
	
	
}

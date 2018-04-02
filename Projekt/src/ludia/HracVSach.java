package ludia;

import udalosti.ExternyTurnaj;
import urovne.Uroven;

public class HracVSach {
	private String meno;
	private String priezvisko;
	private Uroven uroven;
	
	public HracVSach(String meno, String priezvisko){
		this.meno = new String(meno);
		this.priezvisko = new String(priezvisko);
	}
	
	public HracVSach(String meno, String priezvisko, Uroven uroven){
		this.meno = new String(meno);
		this.priezvisko = new String(priezvisko);
		this.uroven = uroven;
	}
	
	public String toString() {
		return meno +" "+ priezvisko +" ("+ uroven.getRating() + ")";
	}
	
	public void setUroven(Uroven u) {
		this.uroven = u;
	}
	
	public int getRating() {
		return uroven.getRating();
	}
	
	public void setRating(int rating) {
		uroven.setRating(rating);
	}

	public void registrujSaDoTurnaju(ExternyTurnaj externyTurnaj) {
		externyTurnaj.pridatUcastnika(this);
	}
}


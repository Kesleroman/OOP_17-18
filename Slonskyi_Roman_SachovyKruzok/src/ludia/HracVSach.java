package ludia;

import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnajPreNovacikov;
import udalosti.LokalnyTurnajPrePokrocilych;
import urovne.Uroven;

public abstract class HracVSach{
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
		return meno +" "+ priezvisko +" (" + uroven.toString() +"-"+ uroven.getRating() + ")";
	}
	
	public void setUroven(Uroven u) {
		this.uroven = u;
	} 
	
	public Uroven getUroven(){
		return this.uroven;
	}
	
	public int getRating() {
		return uroven.getRating();
	}
	
	public void setRating(int rating) {
		uroven.setRating(rating);
	}

	public abstract void registrujSaDoTurnaju(ExternyTurnaj externyTurnaj);
	public abstract void registrujSaDoTurnaju(LokalnyTurnajPrePokrocilych lokalnyTurnaj);
	public abstract void registrujSaDoTurnaju(LokalnyTurnajPreNovacikov lokalnyTurnaj);
}


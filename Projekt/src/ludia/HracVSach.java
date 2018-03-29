package ludia;

import udalosti.ExternyTurnaj;
import urovne.Uroven;

public abstract class HracVSach {
	private String meno;
	private String priezvisko;
	
	private Uroven uroven;
	
	public void setUroven(Uroven u) {
		this.uroven = u;
	}
	
	public HracVSach(String meno, String priezvisko){
		this.meno = new String(meno);
		this.priezvisko = new String(priezvisko);
	}

	public void registrujSaDoETurnaju(ExternyTurnaj externyTurnaj) {
		externyTurnaj.pridatUcastnika(this);
	}
}

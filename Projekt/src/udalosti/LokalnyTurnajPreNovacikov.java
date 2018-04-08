package udalosti;

import ludia.HracVSach;
import urovne.DruhaTrieda;

public class LokalnyTurnajPreNovacikov extends Turnaj {
	private DruhaTrieda maxUroven = new DruhaTrieda();
	
	public void registracia(HracVSach ucastnik) {
		if(ucastnik.getUroven().compareTo(maxUroven) < 0)
			ucastnik.registrujSaDoTurnaju(this);
	}
}

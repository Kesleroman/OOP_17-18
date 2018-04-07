package udalosti;

import ludia.HracVSach;
import urovne.TretiaTrieda;

public class LokalnyTurnajPreNovacikov extends Turnaj {
	private TretiaTrieda maxUroven = new TretiaTrieda(1599);
	public void registracia(HracVSach ucastnik) {
		if(ucastnik.getUroven().compareTo(maxUroven) <= 0)
			ucastnik.registrujSaDoTurnaju(this);
	}
}

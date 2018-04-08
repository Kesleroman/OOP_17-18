package udalosti;

import ludia.HracVSach;
import urovne.TretiaTrieda;

public class ExternyTurnaj extends Turnaj{
	public void registracia(HracVSach ucastnik) {
		if(ucastnik.getUroven().compareTo(new TretiaTrieda()) >= 0) {
			ucastnik.registrujSaDoTurnaju(this);
		}
	}
}

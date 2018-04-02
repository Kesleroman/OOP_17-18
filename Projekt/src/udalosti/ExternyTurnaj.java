package udalosti;

import ludia.HracVSach;

public class ExternyTurnaj extends Turnaj implements RegistraciaDoTurnaju {

	public void registracia(HracVSach ucastnik) {
		// TODO Vytvorit podmienku ucasti v turnaji
		ucastnik.registrujSaDoTurnaju(this);
	}
}

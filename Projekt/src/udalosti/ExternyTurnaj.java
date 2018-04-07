package udalosti;

import ludia.HracVSach;

public class ExternyTurnaj extends Turnaj{

	public void registracia(HracVSach ucastnik) {
		// TODO Vytvorit podmienku ucasti v turnaji
		ucastnik.registrujSaDoTurnaju(this);
	}
}

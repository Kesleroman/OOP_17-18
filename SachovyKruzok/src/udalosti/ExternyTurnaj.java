package udalosti;

import ludia.HracVSach;

public class ExternyTurnaj extends Turnaj{
	public void registracia(HracVSach ucastnik) {
			ucastnik.registrujSaDoTurnaju(this);
	}
}

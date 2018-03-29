package udalosti;

import ludia.HracVSach;

public class ExternyTurnaj extends Turnaj implements RegistraciaDoTurnaju {

	public ExternyTurnaj(int pocetUcastnikov) {
		super(pocetUcastnikov);
	}

	public void registracia(HracVSach ucastnik) {
		ucastnik.registrujSaDoETurnaju(this);
	}
	
}

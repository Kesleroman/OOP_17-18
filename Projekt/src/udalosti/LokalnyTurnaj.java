package udalosti;

import ludia.HracVSach;
import ludia.Skupina;
import ludia.Ziak;

public class LokalnyTurnaj extends Turnaj implements RegistraciaDoTurnaju{

	public LokalnyTurnaj(int pocetUcastnikov) {
		super(pocetUcastnikov);
	}

	public void registracia(HracVSach ucastnik) {
		((Ziak) ucastnik).registrujSaDoTurnaju(this);
	}
}
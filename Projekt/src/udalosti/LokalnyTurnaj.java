package udalosti;

import ludia.HracVSach;
import ludia.Ziak;

public class LokalnyTurnaj extends Turnaj implements RegistraciaDoTurnaju{
	public void registracia(HracVSach ucastnik) {
		((Ziak) ucastnik).registrujSaDoTurnaju(this);
	}
}
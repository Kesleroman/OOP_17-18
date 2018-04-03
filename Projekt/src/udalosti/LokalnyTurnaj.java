package udalosti;

import ludia.HracVSach;
import ludia.Ziak;

public class LokalnyTurnaj extends Turnaj implements RegistraciaDoTurnaju{
	public void registracia(HracVSach ucastnik) {
		((Ziak) ucastnik).registrujSaDoTurnaju(this);
	}
	
	public void povolitSaZucastnitVETurnaji() {
		for(HracVSach hrac : this.ucastnici) {
			((Ziak) hrac).registraciaDoTurnaju = true;
		}
	}
}
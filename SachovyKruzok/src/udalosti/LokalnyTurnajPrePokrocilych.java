package udalosti;

import ludia.HracVSach;
import ludia.Ziak;
import urovne.DruhaTrieda;

public class LokalnyTurnajPrePokrocilych extends LokalnyTurnajPreNovacikov{
	private final DruhaTrieda minUroven = new DruhaTrieda();
	
	public void registracia(HracVSach ucastnik) {
		if(ucastnik.getUroven().compareTo(minUroven) >= 0)
			ucastnik.registrujSaDoTurnaju(this);
	}
	
	public void povolitSaZucastnitVETurnaji() {
		for(HracVSach hrac : this.ucastnici) {
			((Ziak) hrac).registraciaDoTurnaju = true;
		}
	}
}
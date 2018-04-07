package udalosti;

import java.util.ArrayList;

import ludia.HracVSach;

public abstract class Turnaj implements RegistraciaDoTurnaju{
	protected ArrayList<HracVSach> ucastnici = new ArrayList<HracVSach>();
	
	public void pridatUcastnika(HracVSach hrac) {
		ucastnici.add(hrac);
	}
}

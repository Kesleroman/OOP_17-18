package udalosti;

import java.util.ArrayList;
import java.util.List;

import ludia.HracVSach;

public abstract class Turnaj {
	
	protected ArrayList<HracVSach> ucastnici;
	
	public Turnaj(int pocetUcastnikov) {
		this.ucastnici = new ArrayList<>(pocetUcastnikov);
	}
	
	public void pridatUcastnika(HracVSach hrac) {
		ucastnici.add(hrac);
	}
	
}

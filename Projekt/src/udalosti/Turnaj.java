package udalosti;

import java.util.ArrayList;
import java.util.List;

import ludia.HracVSach;

public abstract class Turnaj {
	private int pocetUcastnikov;
	
	private List<HracVSach> ucastnici;
	
	public Turnaj(int pocetUcastnikov) {
		this.pocetUcastnikov = pocetUcastnikov;
		this.ucastnici = new ArrayList<>(pocetUcastnikov);
	}
	
	public void pridatUcastnika(HracVSach hrac) {
		ucastnici.add(hrac);
	}
	
}

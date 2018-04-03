package udalosti;

import java.util.ArrayList;

import ludia.HracVSach;
import ludia.Ziak;
import urovne.Majster;

public abstract class SachovaFederacia {
	
	private static final ArrayList<HracVSach> ucastnici = vytvoritUcastnikovFederacie();
	
	private static ArrayList<HracVSach> vytvoritUcastnikovFederacie(){
		int pocetUcastnikov = 48;
		ArrayList<HracVSach> temp = new ArrayList<HracVSach>(pocetUcastnikov);
		
		for(int i = 0; i < pocetUcastnikov; ++i) {
			temp.add(new Ziak( i +" Roman", "Slonskyi", new Majster(2500 + (int)(100 * Math.random()))));
			//TODO: Random levels, names.
		}
		
		return temp;
	}
	
	public static ExternyTurnaj vytvoritTurnaj() {
		ExternyTurnaj turnaj = new ExternyTurnaj();
		for(HracVSach ucastnik : ucastnici) {
			turnaj.pridatUcastnika(ucastnik);
		}
		
		return turnaj;
	}
}
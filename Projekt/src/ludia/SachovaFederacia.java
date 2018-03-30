package ludia;

import java.util.ArrayList;

import udalosti.ExternyTurnaj;
import urovne.Majster;

public class SachovaFederacia {
	
	private static final ArrayList<HracVSach> ucastnici = vytvoritUcastnikovFederacie();
	
	private static ArrayList<HracVSach> vytvoritUcastnikovFederacie(){
		int pocetUcastnikov = 48;
		ArrayList<HracVSach> temp = new ArrayList<HracVSach>(pocetUcastnikov);
		
		for(int i = 0; i < pocetUcastnikov; ++i) {
			temp.add(new HracVSach("Roman", "Slonskyi", new Majster(3000))); //TODO: Random levels, names.
		}
		
		return temp;
	}
	
	public static ExternyTurnaj vytvoritTurnaj(int pocetUcastnikov) {
		
		ExternyTurnaj turnaj = new ExternyTurnaj(pocetUcastnikov + ucastnici.size());
		for(HracVSach ucastnik : ucastnici) {
			turnaj.pridatUcastnika(ucastnik);
		}
		
		return turnaj;
	}
	
}

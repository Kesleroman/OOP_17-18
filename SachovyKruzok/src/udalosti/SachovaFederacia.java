package udalosti;

import java.util.ArrayList;

import ludia.HracVSach;
import ludia.Ziak;
import random.NahodnaUroven;
import random.NahodneMeno;
import urovne.TretiaTrieda;
import urovne.Uroven;

public abstract class SachovaFederacia {
	
	private static final ArrayList<HracVSach> ucastnici = vytvoritUcastnikovFederacie();
	
	private static ArrayList<HracVSach> vytvoritUcastnikovFederacie(){
		int pocetUcastnikov = 48;
		NahodneMeno meno = new NahodneMeno("Mena.txt");
		NahodneMeno priezvisko = new NahodneMeno("Priezviska.txt");
		ArrayList<HracVSach> temp = new ArrayList<HracVSach>(pocetUcastnikov);
		
		for(int i = 0; i < pocetUcastnikov; ++i) {
			Uroven u;
			while(true) {
				u = NahodnaUroven.vratNahodnuUroven();
				if(u.compareTo(new TretiaTrieda()) >= 0) {
					break;
				}
			}
			temp.add(new Ziak( meno.vratNahodneMeno(), priezvisko.vratNahodneMeno(), u));
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
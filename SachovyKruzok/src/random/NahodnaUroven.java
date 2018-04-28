package random;

import java.util.Random;

import urovne.DruhaTrieda;
import urovne.Novacik;
import urovne.PrvaTrieda;
import urovne.StvrtaTrieda;
import urovne.TretiaTrieda;
import urovne.Uroven;

public class NahodnaUroven {
	public static Uroven vratNahodnuUroven() {
		Random rnd = new Random();
		int uroven = rnd.nextInt(5);
		switch(uroven) {
			case 0: return new Novacik();
			case 1:	return new StvrtaTrieda();
			case 2:	return new TretiaTrieda();
			case 3: return new DruhaTrieda();
			case 4: return new PrvaTrieda();
			default:
				return null;
		}
	}
}
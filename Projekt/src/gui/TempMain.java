package gui;

import kruzok.CastKruzku;
import kruzok.Kruzok;
import kruzok.Skupina;
import ludia.*;
import udalosti.ExternyTurnaj;
import udalosti.PriebehTurnaju;
import udalosti.SachovaFederacia;
import urovne.Majster;

public class TempMain {

	public static void main(String[] args) {
		Skupina sk = new Skupina();
		
		for(int i = 0; i < 10; ++i) {
			sk.pridatDoSkupina(new Ziak(i + "lol", "LOL", new Majster(2500 + (int)(100 * Math.random()))));
		}
		Ucitel u = new Ucitel("Kek", "Lol");
		u.priraditSkupinu(sk);
		
		Kruzok k = new Kruzok();
		k.ucitelia.pridatDoSkupina(u);
		System.out.println(k);

		ExternyTurnaj exT = SachovaFederacia.vytvoritTurnaj();
		for(CastKruzku hrac : sk) {
			exT.registracia((Ziak) hrac);
		} 
		//exT.registracia(u); TODO
		
		PriebehTurnaju priebeh = new PriebehTurnaju(exT);
		
		for(int i = 0; i < 10; ++i) {
			priebeh.sortovanie();
			priebeh.vytvoritSkupiny();
			priebeh.vytvoritPary();
			priebeh.hra();
		}
		priebeh.sortovanie();
		System.out.println(priebeh);
	}

}

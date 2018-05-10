package kruzok;

import java.util.ArrayList;

import ludia.HracVSach;
import ludia.Ucitel;
import ludia.Ziak;
import random.NahodnaUroven;
import random.NahodneMeno;

public class Kruzok implements CastKruzku{
	private Skupina ucitelia = new Skupina();
	private NahodneMeno meno = new NahodneMeno("Mena.txt");
	private NahodneMeno priezvisko = new NahodneMeno("Priezviska.txt");
	
	public String toString() {
		String str = new String("Kruzok:\n");
		
		for(CastKruzku ucitel : ucitelia) {
			str = str.concat("\t" + ucitel.toString() + "\n\tSkupina:\n" + ((Ucitel) ucitel).getSkupina().toString() + "\n");
		}
		return str;
	}
	
	public Skupina getUcitelia() {
		return this.ucitelia;
	}
	
	public void vytvoritSkupinu() {
		Ucitel u = new Ucitel(meno.vratNahodneMeno(), priezvisko.vratNahodneMeno());
		ucitelia.pridatDoSkupina(u);
		
		Skupina skupina = new Skupina();
		
		for(int i = 0; i < 10; ++i) {
			skupina.pridatDoSkupina(new Ziak(meno.vratNahodneMeno(), priezvisko.vratNahodneMeno(), NahodnaUroven.vratNahodnuUroven()));
		}
		
		u.priraditSkupinu(skupina);
	}

	public ArrayList<? extends HracVSach> vybratHracov() {
		ArrayList<HracVSach> arr = new ArrayList<HracVSach>();
		arr.addAll(ucitelia.vybratHracov());
		
		return arr;
	}
	
	public void cvicenie() {
		for(CastKruzku ucitel : ucitelia) {
			((Ucitel) ucitel).previestCvicenie();
		}
	}
}
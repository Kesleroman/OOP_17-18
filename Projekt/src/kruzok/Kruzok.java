package kruzok;

import java.util.ArrayList;

import ludia.HracVSach;
import ludia.Ucitel;
import ludia.Ziak;
import urovne.Novacik;

public class Kruzok implements CastKruzku{
	public Skupina ucitelia = new Skupina();
	
	public Kruzok() {
		Ucitel u1 = new Ucitel("Jaroslav", "Mudry"),
				u2 = new Ucitel("Ondrej", "Mudry");
		
		ucitelia.pridatDoSkupina(u1);
		ucitelia.pridatDoSkupina(u2);
		
		Skupina skupina1 = new Skupina(),
				skupina2 = new Skupina();
		
		for(int i = 0; i < 10; ++i) {
			skupina1.pridatDoSkupina(new Ziak("Meno", "Priezvisko", new Novacik(1000 + (int)(100 * Math.random() ))));
			skupina2.pridatDoSkupina(new Ziak("Meno", "Priezvisko", new Novacik(1000 + (int)(100 * Math.random() ))));
		}
		
		u1.priraditSkupinu(skupina1);
		u2.priraditSkupinu(skupina2);
	}
	
	public String toString() {
		String str = new String("Kruzok:\n");
		
		for(CastKruzku ucitel : ucitelia) {
			str = str.concat("\t" + ucitel.toString() + "\n\tSkupina:\n" + ((Ucitel) ucitel).getSkupina().toString() + "\n");
		}
		return str;
	}

	public ArrayList<? extends HracVSach> vybratHracov() {
		ArrayList<HracVSach> arr = new ArrayList<HracVSach>();
		arr.addAll(ucitelia.vybratHracov());
		
		return arr;
	}
}
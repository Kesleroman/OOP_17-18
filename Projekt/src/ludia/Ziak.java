package ludia;

import kruzok.CastKruzku;
import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnaj;
import urovne.Uroven;

public class Ziak extends HracVSach implements CastKruzku{
    public boolean registraciaDoTurnaju = false;
	
	public Ziak(String meno, String priezvisko) {
		super(meno, priezvisko);
	}
	
	public Ziak(String meno, String priezvisko, Uroven uroven){
		super(meno, priezvisko, uroven);
	}
	
	public void registrujSaDoTurnaju(LokalnyTurnaj lTurnaj) {
		lTurnaj.pridatUcastnika(this);
	}
	
	public void registrujSaDoTurnaju(ExternyTurnaj externyTurnaj) {
		if(registraciaDoTurnaju) {
			externyTurnaj.pridatUcastnika(this);
		}
	}
}
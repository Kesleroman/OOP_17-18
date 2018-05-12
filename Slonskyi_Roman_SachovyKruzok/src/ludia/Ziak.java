package ludia;

import java.util.ArrayList;

import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnajPreNovacikov;
import udalosti.LokalnyTurnajPrePokrocilych;
import urovne.Uroven;

public class Ziak extends HracVSach {
    public boolean registraciaDoTurnaju = false;
	
	public Ziak(String meno, String priezvisko) {
		super(meno, priezvisko);
	}
	
	public Ziak(String meno, String priezvisko, Uroven uroven){
		super(meno, priezvisko, uroven);
	}
	
	public void registrujSaDoTurnaju(LokalnyTurnajPrePokrocilych lTurnaj) {
		lTurnaj.pridatUcastnika(this);
	}
	
	public void registrujSaDoTurnaju(ExternyTurnaj externyTurnaj) {
		if(registraciaDoTurnaju) {
			externyTurnaj.pridatUcastnika(this);
		}
	}
	
	public void registrujSaDoTurnaju(LokalnyTurnajPreNovacikov lTurnaj) {
		lTurnaj.pridatUcastnika(this);
	}

	public ArrayList<? extends HracVSach> vybratHracov() {
		ArrayList<HracVSach> arr = new ArrayList<HracVSach>();
		arr.add(this);
		return arr;
	}
}
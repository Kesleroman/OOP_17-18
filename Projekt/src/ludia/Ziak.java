package ludia;

import udalosti.LokalnyTurnaj;

public class Ziak extends HracVSach implements CastKruzku{
	
	public Ziak(String meno, String priezvisko) {
		super(meno, priezvisko);
	}
	
	public void registrujSaDoLTurnaju(LokalnyTurnaj lTurnaj) {
		lTurnaj.pridatUcastnika(this);
	}
}
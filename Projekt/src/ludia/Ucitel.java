package ludia;

import udalosti.LokalnyTurnaj;
import urovne.Majster;

public class Ucitel extends HracVSach implements CastKruzku{
	
	private Skupina skupina;
	
	public Ucitel(String meno, String priezvisko) {
		super(meno, priezvisko);
		this.setUroven(new Majster());
	}
	
	public LokalnyTurnaj vytvoritTurnaj() {
		LokalnyTurnaj turnaj = new LokalnyTurnaj(skupina.pocetZiakov());
		return turnaj;
	}
	
}

package ludia;

import kruzok.CastKruzku;
import kruzok.Skupina;
import udalosti.LokalnyTurnaj;
import urovne.Majster;

public class Ucitel extends HracVSach implements CastKruzku{
	
	private Skupina skupina;
	
	public Ucitel(String meno, String priezvisko) {
		super(meno, priezvisko);
		this.setUroven(new Majster(2500)); // TODO
	}
	
	public String toString() {
		return "Ucitel " + super.toString();
	}
	
	public void priraditSkupinu(Skupina s) {
		this.skupina = s;
	}
	
	public Skupina getSkupina() {
		return this.skupina;
	}
	
	public LokalnyTurnaj vytvoritTurnaj() {
		LokalnyTurnaj turnaj = new LokalnyTurnaj();
		
		for(CastKruzku ucastnik : skupina) {
			turnaj.registracia( (Ziak)ucastnik );
		}
		
		return turnaj;
	}
	
}

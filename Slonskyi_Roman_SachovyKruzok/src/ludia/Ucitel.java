package ludia;

import java.util.ArrayList;
import java.util.Random;

import kruzok.CastKruzku;
import kruzok.Skupina;
import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnajPreNovacikov;
import udalosti.LokalnyTurnajPrePokrocilych;
import urovne.Majster;

public class Ucitel extends HracVSach implements CastKruzku{
	
	private Skupina skupina;
	
	public Ucitel(String meno, String priezvisko) {
		super(meno, priezvisko);
		this.setUroven(new Majster(2500));
	}
	
	public String toString() {
		return "Ucitel " + super.toString();
	}
	
	public void priraditSkupinu(Skupina s) {
		this.skupina = s;
		s.pridatUcitela(this);
	}
	
	public Skupina getSkupina() {
		return this.skupina;
	}
	
	public LokalnyTurnajPrePokrocilych vytvoritTurnaj() {
		LokalnyTurnajPrePokrocilych turnaj = new LokalnyTurnajPrePokrocilych();
		
		for(CastKruzku ucastnik : skupina) {
			turnaj.registracia( (Ziak)ucastnik );
		}
		
		return turnaj;
	}

	public ArrayList<? extends HracVSach> vybratHracov() {
		ArrayList<HracVSach> arr = new ArrayList<HracVSach>();
		arr.addAll(skupina.vybratHracov());
		arr.add(this);
		
		return arr;
	}

	public void registrujSaDoTurnaju(ExternyTurnaj externyTurnaj) {
		externyTurnaj.pridatUcastnika(this);
	}
	
	public void registrujSaDoTurnaju(LokalnyTurnajPrePokrocilych lokalnyTurnaj) {} // Ucitel nemoze sa zucastnit v lokalnom turnaji.
	public void registrujSaDoTurnaju(LokalnyTurnajPreNovacikov lokalnyTurnaj) {}
	
	public void previestCvicenie() {
		Random rnd = new Random();
		int novyRating;
		
		for(CastKruzku ziak : skupina) {
			novyRating = rnd.nextInt(10) + ((Ziak) ziak).getRating();
			((Ziak) ziak).setRating(novyRating);
		}
	}
}

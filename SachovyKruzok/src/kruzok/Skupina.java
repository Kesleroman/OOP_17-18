package kruzok;

import java.util.ArrayList;
import java.util.Iterator;

import ludia.HracVSach;
import ludia.Ucitel;

public class Skupina implements CastKruzku, Iterable<CastKruzku>{
	private ArrayList<CastKruzku> skupina = new ArrayList<>();
	private Ucitel ucitel;
	
	public void pridatDoSkupina(CastKruzku cast){
		skupina.add(cast);
	}
	
	public void pridatUcitela(Ucitel ucitel) {
		this.ucitel = ucitel;
	}
	
	public int pocetZiakov(){
		return skupina.size();
	}
	
	public Ucitel getUcitel() {
		return this.ucitel;
	}
	
	public String toString() {
		String str = new String();
		for(CastKruzku cast : skupina) {
			str = str.concat("\t" + cast.toString() + "\n");
		}
		return str;
	}

	public Iterator<CastKruzku> iterator() {
		return skupina.iterator();
	}

	public ArrayList<? extends HracVSach> vybratHracov() {
		ArrayList<HracVSach> arr = new ArrayList<HracVSach>();
		for(CastKruzku cast: skupina) {
			arr.addAll(cast.vybratHracov());
		}
		
		return arr;
	}
}

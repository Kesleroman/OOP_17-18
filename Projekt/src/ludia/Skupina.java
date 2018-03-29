package ludia;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Skupina implements CastKruzku, Iterable<CastKruzku>{
	private List<CastKruzku> skupina = new ArrayList<>();
	
	public void pridatDoSkupina(CastKruzku cast){
		skupina.add(cast);
	}
	
	public int pocetZiakov(){
		return skupina.size();
	}

	public Iterator<CastKruzku> iterator() {
		return skupina.iterator();
	}
}

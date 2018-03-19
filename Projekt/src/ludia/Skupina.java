package ludia;

import java.util.ArrayList;
import java.util.List;

public class Skupina implements CastKruzku{
	private List<CastKruzku> skupina = new ArrayList();
	
	public void pridatDoSkupina(CastKruzku cast){
		skupina.add(cast);
	}
}

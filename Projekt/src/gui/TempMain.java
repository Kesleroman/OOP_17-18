package gui;

import ludia.*;

public class TempMain {

	public static void main(String[] args) {
		Skupina sk = new Skupina();
		
		for(int i = 0; i < 10; ++i) {
			sk.pridatDoSkupina(new Ziak(null, null));
		}
		
		for(CastKruzku c : sk) {
			System.out.println(c.toString());
		}
	}

}

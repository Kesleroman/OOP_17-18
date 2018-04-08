package random;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class NahodneMeno {
	private FileReader fr;
	private Scanner sc;
	private String fileName;
	
	public NahodneMeno(String fileName){
		this.fileName = new String(fileName);
	}
	
	public String vratNahodneMeno(){
		try {
			fr = new FileReader(fileName);
			sc = new Scanner(fr);
		} catch (FileNotFoundException e2) {
			e2.printStackTrace();
		}
		
		int pocetMien = 0;
		while(sc.hasNext()) { // Zistime pocet mien v subore
			sc.next();
			pocetMien++;
		}
		
		try {
			fr = new FileReader(fileName);
			sc = new Scanner(fr);
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		
		
		int indexMena;
		try {
			indexMena = Random.class.newInstance().nextInt(pocetMien);
			while(indexMena-- != 0) { sc.next(); }
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	
		String meno = new String(sc.next());
		sc.close();
		
		return meno;
	}
}

package gui;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import kruzok.Kruzok;
import ludia.HracVSach;
import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnajPreNovacikov;
import udalosti.LokalnyTurnajPrePokrocilych;
import udalosti.SachovaFederacia;
import vynimky.NespravnyVstup;
import vynimky.NieJeVstup;

/**
 * Trieda HlavnaScena je zotpovedna za manipulaciu Kruzkom.
 */
public class HlavnaScena {
	private static Kruzok kruzok = new Kruzok();
	
	public static Kruzok getKruzok() {
		return HlavnaScena.kruzok;
	}
	
	protected static void vytvoritSkupiny(String vstup) throws NieJeVstup, NespravnyVstup {
		if(vstup.isEmpty()) {
			Main.vynimka = true;
			throw new NieJeVstup();
		}
		
		try {
			int pocetSkupin = Integer.parseInt(vstup);
			
			for(int i = 0; i < pocetSkupin; ++i) {
				kruzok.vytvoritSkupinu();
			}
		}
		catch(NumberFormatException e) {
			Main.vynimka = true;
			throw new NespravnyVstup();
		}
	}

	protected static Scene vytvoritHlavnuScenu() {
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 640, 480);
		Button cvicenie = new Button();
		Button pLokTurnaj = new Button();
		Button nLokTurnaj = new Button();
		Button exTurnaj = new Button();
		Button info = new Button();
		TextArea textArea = new TextArea();
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		pane.getChildren().add(cvicenie);
		pane.getChildren().add(nLokTurnaj);
		pane.getChildren().add(pLokTurnaj);
		pane.getChildren().add(exTurnaj);
		pane.getChildren().add(info);
		pane.getChildren().add(scrollPane);
		
		cvicenie.setText("Cvicenie");
		nLokTurnaj.setText("Lokalny turnaj (Novaciky)");
		pLokTurnaj.setText("Lokalny turnaj (Pokrocili)");
		exTurnaj.setText("Externy turnaj");
		info.setText("Informacia o kruzku");
		
		cvicenie.setOnAction(e -> {
			kruzok.cvicenie();
		});
		
		info.setOnAction(e -> {
			textArea.clear();
			textArea.appendText(kruzok.toString());
		});
		
		nLokTurnaj.setOnAction(e ->{
			ArrayList<HracVSach> hraci = new ArrayList<>(kruzok.vybratHracov());
			LokalnyTurnajPreNovacikov turnaj = new LokalnyTurnajPreNovacikov();
			
			for(HracVSach ucastnik : hraci)
				turnaj.registracia(ucastnik);

			Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj)); 
		});
		
		pLokTurnaj.setOnAction(e ->{
			ArrayList<HracVSach> hraci = new ArrayList<>(kruzok.vybratHracov());
			LokalnyTurnajPrePokrocilych turnaj = new LokalnyTurnajPrePokrocilych();
			
			for(HracVSach ucastnik : hraci)
				turnaj.registracia(ucastnik);

			Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj)); 
		});
		
		exTurnaj.setOnAction(e ->{
			ExternyTurnaj turnaj = SachovaFederacia.vytvoritTurnaj();
			ArrayList<HracVSach> hraci = new ArrayList<>(kruzok.vybratHracov());
			for(HracVSach hrac: hraci) {
				 hrac.registrujSaDoTurnaju(turnaj);
			}
			Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj));
		});
		
		return scene;
	}
}

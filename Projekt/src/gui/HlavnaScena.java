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

public class HlavnaScena {
	private static Kruzok kruzok = new Kruzok();

	protected static Scene vytvoritHlavnuScenu() {
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 640, 480);
		Button pLokTurnaj = new Button();
		Button nLokTurnaj = new Button();
		Button exTurnaj = new Button();
		Button info = new Button();
		TextArea textArea = new TextArea();
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		pane.getChildren().add(nLokTurnaj);
		pane.getChildren().add(pLokTurnaj);
		pane.getChildren().add(exTurnaj);
		pane.getChildren().add(info);
		pane.getChildren().add(scrollPane);
		
		nLokTurnaj.setText("Lokalny turnaj (Novaciky)");
		pLokTurnaj.setText("Lokalny turnaj (Pokrocili)");
		exTurnaj.setText("Externy turnaj");
		info.setText("Informacia o kruzku");
		
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

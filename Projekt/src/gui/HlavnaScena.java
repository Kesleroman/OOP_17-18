package gui;

import java.util.ArrayList;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import kruzok.CastKruzku;
import kruzok.Kruzok;
import ludia.HracVSach;
import ludia.Ucitel;
import udalosti.ExternyTurnaj;
import udalosti.LokalnyTurnajPreNovacikov;
import udalosti.LokalnyTurnajPrePokrocilych;
import udalosti.SachovaFederacia;
import udalosti.Turnaj;

public class HlavnaScena {
	private static Kruzok kruzok = new Kruzok();

	protected static Scene vytvoritHlavnuScenu() {
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 640, 480);
		Button lokTurnaj = new Button();
		Button exTurnaj = new Button();
		Button info = new Button();
		TextArea textArea = new TextArea();
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		pane.getChildren().add(lokTurnaj);
		pane.getChildren().add(exTurnaj);
		pane.getChildren().add(info);
		pane.getChildren().add(scrollPane);
		
		lokTurnaj.setText("Lokalny turnaj");
		exTurnaj.setText("Externy turnaj");
		info.setText("Informacia o kruzku");
		
		info.setOnAction(e -> {
			textArea.clear();
			textArea.appendText(kruzok.toString());
		});
		
		lokTurnaj.setOnAction(e ->{
			ArrayList<HracVSach> hraci = new ArrayList<>(kruzok.vybratHracov());
			ArrayList<Turnaj> arr = new ArrayList<>();
			arr.add(new LokalnyTurnajPreNovacikov());
			arr.add(new LokalnyTurnajPrePokrocilych());
			
			for(HracVSach ucastnik : hraci) {
				arr.get(0).registracia(ucastnik);
				arr.get(1).registracia(ucastnik);
			}
			for(Turnaj turnaj : arr) {
				Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj)); // TODO
			}
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

package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import kruzok.CastKruzku;
import kruzok.Kruzok;
import ludia.HracVSach;
import ludia.Ucitel;
import ludia.Ziak;
import udalosti.ExternyTurnaj;
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
			for(CastKruzku cast: kruzok.ucitelia) {
				Turnaj turnaj = ((Ucitel) cast).vytvoritTurnaj();
				Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj)); // TODO 
			}
		});
		
		exTurnaj.setOnAction(e ->{
			ExternyTurnaj turnaj = SachovaFederacia.vytvoritTurnaj();
			for(CastKruzku ucitel : kruzok.ucitelia) {
				((HracVSach) ucitel).registrujSaDoTurnaju(turnaj);
				for(CastKruzku ziak : ((Ucitel) ucitel).getSkupina()) {
					((HracVSach) ziak).registrujSaDoTurnaju(turnaj);
				}
			}
			Main.primaryStage.setScene(ScenaTurnaj.vytvoritTurnaj(turnaj));
		});
		
		return scene;
	}
}

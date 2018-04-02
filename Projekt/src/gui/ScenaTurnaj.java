package gui;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.FlowPane;
import udalosti.PriebehTurnaju;
import udalosti.Turnaj;

public class ScenaTurnaj{
	static Scene vytvoritTurnaj(Turnaj turnaj){
		PriebehTurnaju priebeh = new PriebehTurnaju(turnaj);
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 640, 480);
		Button naspat = new Button();
		Button celyTurnaj = new Button();
		Button vysledky = new Button();
		
		TextArea textArea = new TextArea();
		ScrollPane scrollPane = new ScrollPane(textArea);
		
		pane.getChildren().add(scrollPane);
		pane.getChildren().add(naspat);
		pane.getChildren().add(celyTurnaj);
		
		naspat.setText("Naspat");
		celyTurnaj.setText("Cely turnaj");
		vysledky.setText("Vysledky");
		
		naspat.setOnAction(e -> {
			Main.primaryStage.setScene(HlavnaScena.vytvoritHlavnuScenu());
		});
		
		celyTurnaj.setOnAction(e -> {
			priebeh.celyTurnaj();
			pane.getChildren().add(vysledky);
			pane.getChildren().remove(celyTurnaj);
		});
		
		vysledky.setOnAction(e -> {
			textArea.clear();
			textArea.appendText(priebeh.vysledky());
		});
		
		return scene;
	}
}

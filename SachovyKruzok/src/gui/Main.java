package gui;


import javafx.application.*;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import vynimky.NespravnyVstup;
import vynimky.NieJeVstup;

public class Main extends Application{
	protected static Stage primaryStage;
	
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Sachovy kruzok. alpha");
		
		FlowPane prveOkno = new FlowPane(Orientation.VERTICAL);
		prveOkno.setColumnHalignment(HPos.RIGHT);
		prveOkno.setVgap(10);
		
		Scene scene = new Scene(prveOkno, 640, 480);
		Button zacat = new Button();
		TextField pocetSkupin = new TextField();
		Label skupiny = new Label("Pocet skupin");
		
		prveOkno.getChildren().add(pocetSkupin);
		prveOkno.getChildren().add(skupiny);
		prveOkno.getChildren().add(zacat);
		
		zacat.setText("Zacat.");
		
		zacat.setOnAction(e -> {
			
				Thread thread = new Thread(new Runnable() {
					public void run() {
						try {
							HlavnaScena.vytvoritSkupiny(pocetSkupin.getText());
						} catch (NieJeVstup | NespravnyVstup e1) {/* Osetrenie je v OsetrenieVynimiek.aj */}
					}
				});
				thread.run();
				
				primaryStage.setScene(HlavnaScena.vytvoritHlavnuScenu() );
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

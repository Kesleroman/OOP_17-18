package gui;


import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
	protected static Stage primaryStage;
	
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Sachovy kruzok. alpha");
		
		Pane prveOkno = new Pane();
		Scene scene = new Scene(prveOkno, 640, 480);
		Button zacat = new Button();
		TextField pocetSkupin = new TextField();
		Label skupiny = new Label("Pocet skupin");
		
		prveOkno.getChildren().add(pocetSkupin);
		prveOkno.getChildren().add(skupiny);
		prveOkno.getChildren().add(zacat);
		
		zacat.setText("Zacat.");
		zacat.setLayoutX(scene.getWidth()/2 - 20);
		zacat.setLayoutY(scene.getHeight()/2 - 5);
		
		zacat.setOnAction(e -> {
			primaryStage.setScene(HlavnaScena.vytvoritHlavnuScenu());
		});
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}

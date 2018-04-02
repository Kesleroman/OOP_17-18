package gui;


import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{
	protected static Stage primaryStage;
	
	public void start(Stage primaryStage) throws Exception {
		Main.primaryStage = primaryStage;
		primaryStage.setTitle("Sachovy kruzok. alpha");
		
		FlowPane prveOkno = new FlowPane();
		Scene scene = new Scene(prveOkno, 640, 480);
		Button zacat = new Button();
		
		prveOkno.getChildren().add(zacat);
		
		zacat.setText("Zacat.");
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

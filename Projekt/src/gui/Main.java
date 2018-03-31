package gui;


import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;

public class Main extends Application{
	Label label = new Label("LOL!");
	TextField tfield = new TextField();
	Button zacat = new Button();
	

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sachovy kruzok. alpha");
	
		FlowPane pane = new FlowPane();
		FlowPane prveOkno = new FlowPane();
		Scene scene = new Scene(prveOkno, 640, 480);
		Scene scene2 = new Scene(pane, 640, 480);
	
		prveOkno.getChildren().add(zacat);
		pane.getChildren().add(label);
		pane.getChildren().add(tfield);
		
		zacat.setText("Zacat.");
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		zacat.setOnAction(e -> {
			primaryStage.setScene(scene2);
			primaryStage.show();
		});
	}


	public static void main(String[] args) {
		launch(args);
	}

	
}

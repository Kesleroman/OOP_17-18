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
	Button but = new Button();
	

	public void start(Stage primaryStage) throws Exception {
		primaryStage.setTitle("Sachovy kruzok. alpha");
	
		FlowPane pane = new FlowPane();
		Scene scene = new Scene(pane, 640, 480);
	
		pane.getChildren().add(but);
		pane.getChildren().add(label);
		pane.getChildren().add(tfield);
		
		but.setText("Button");
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		but.setOnAction(e -> {
			tfield.clear(); 
			tfield.appendText("Hello World");
		});
	}


	public static void main(String[] args) {
		launch(args);
	}

	
}

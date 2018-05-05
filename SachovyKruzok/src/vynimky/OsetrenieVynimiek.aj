package vynimky;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import vynimky.NespravnyVstup;
import vynimky.NieJeVstup;
import gui.HlavnaScena;
import java.lang.String;

public aspect OsetrenieVynimiek {
	
	pointcut Vstup(): call(* HlavnaScena.vytvoritSkupiny(String) throws NieJeVstup, NespravnyVstup);
	 void around(): Vstup() {
		 try{
			 proceed();
		 }
		 catch(NieJeVstup e1) {
			 Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Chyba!");
				alert.setContentText("Nie je vstup!");
				alert.showAndWait();
		 }
		 catch(NespravnyVstup e2) {
			 Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Chyba!");
				alert.setContentText("Nespravny vstup!");
				alert.showAndWait();
		 }
	}
}

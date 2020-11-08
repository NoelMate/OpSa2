package gui;

import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;


public class FreizeitbaederControl {
	
	private FreizeitbaederModel freizeitbaederModel;
	private FreizeitbaederView freizeitbaederView;
	

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = new FreizeitbaederModel();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
	}
	
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Erfolg! Der Eintrag wurde vorgenommen.");
			}
			else {
				this.freizeitbaederView.zeigeInformationsfensterAn("Nicht imlementiert!");
			}
		}
		catch (IOException ex) {
			this.freizeitbaederView.zeigeFehlermeldungAn("IO-Fehler", "IOException beim Speichern in die Datei");
		}
		catch (Exception ex) {
			this.freizeitbaederView.zeigeFehlermeldungAn("Fehler nicht bekannt", "Es ist ein Unbekannter Fehler aufgetaucht");
		}
	}
}

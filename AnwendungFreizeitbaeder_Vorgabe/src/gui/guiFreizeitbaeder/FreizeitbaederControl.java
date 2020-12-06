package gui.guiFreizeitbaeder;
import business.*;
import java.io.IOException;

import business.FreizeitbaederModel;
import javafx.stage.Stage;


public class FreizeitbaederControl implements Observer {
	
	private FreizeitbaederModel freizeitbaederModel;
	private FreizeitbaederView freizeitbaederView;
	

	public FreizeitbaederControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.freizeitbaederView = new FreizeitbaederView(this, primaryStage, freizeitbaederModel);
		this.freizeitbaederModel.addObserver(this);
	}
	
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Erfolg! Der Eintrag wurde vorgenommen.");
			}
			else if("txt".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				this.freizeitbaederView.zeigeInformationsfensterAn("Erfolg! Der Eintrag wurde in die TEXT-Datei geschrieben.");
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

	@Override
	public void update() {
		freizeitbaederView.zeigeFreizeitbaederAn();
	}
}

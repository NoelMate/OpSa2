package gui.guiSportstaetten;

import java.io.IOException;
import business.*;
import javafx.stage.Stage;
import gui.guiFreizeitbaeder.*;

public class SportstaettenControl implements Observer {
	
	private FreizeitbaederModel freizeitbaederModel;
	private SportstaettenView sportstaettenView;
	

	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel = FreizeitbaederModel.getInstance();
		this.sportstaettenView = new SportstaettenView(freizeitbaederModel, primaryStage);
		freizeitbaederModel.addObserver(this);
	}
	
	void schreibeFreizeitbaederInDatei(String typ) {
		try {
			if("csv".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInCsvDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Erfolg! Der Eintrag wurde vorgenommen.");
			}
			else if("txt".equals(typ)) {
				this.freizeitbaederModel.schreibeFreizeitbaederInTxtDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Erfolg! Der Eintrag wurde in die TEXT-Datei geschrieben.");
			}
			else {
				this.sportstaettenView.zeigeInformationsfensterAn("Nicht imlementiert!");
			}
		}
		catch (IOException ex) {
			this.sportstaettenView.zeigeFehlermeldungAn("IO-Fehler", "IOException beim Speichern in die Datei");
		}
		catch (Exception ex) {
			this.sportstaettenView.zeigeFehlermeldungAn("Fehler nicht bekannt", "Es ist ein Unbekannter Fehler aufgetaucht");
		}
	}

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}

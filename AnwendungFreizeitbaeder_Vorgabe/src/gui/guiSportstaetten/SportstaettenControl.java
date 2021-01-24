package gui.guiSportstaetten;
import java.io.IOException;
import business.businessSporthallen.SporthallenModel;
import business.businessFrezeitbad.FreizeitbaederModel;
import javafx.stage.Stage;
import ownUtil.Observer;
import ownUtil.PlausiException;

public class SportstaettenControl implements Observer {
	private SportstaettenView sportstaettenView; 
	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	
	public SportstaettenControl(Stage primaryStage) {
		this.freizeitbaederModel	= FreizeitbaederModel.getInstance();
		this.sporthallenModel		= SporthallenModel.getInstance();
		this.sportstaettenView		= new SportstaettenView(primaryStage, freizeitbaederModel, sporthallenModel, this);
		this.freizeitbaederModel.addObserver(this);
	}
	
	void leseSporthallenAusDatei(String typ) {
		try {
			if(typ.equals("csv")) {
				sporthallenModel.leseSporthallenAusCsvDatei();
				this.sportstaettenView.zeigeInformationsfensterAn("Die Daten aus Sporthallen.csv wurden erfolgreich importiert.");
			}
			else {
				this.sportstaettenView.zeigeInformationsfensterAn("Die Datei existiert nicht.");
			}
		} catch (IOException | PlausiException e) {
			this.sportstaettenView.zeigeFehlermeldungAn("Fehler nicht bekannt", "Beim Importieren des ist ein Unbekannter Fehler aufgetaucht");
			e.printStackTrace();
		}
	}

	@Override
	public void update() {
		sportstaettenView.zeigeFreizeitbaederAn();
	}
}

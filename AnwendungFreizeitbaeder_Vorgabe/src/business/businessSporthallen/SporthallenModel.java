package business.businessSporthallen;

import ownUtil.PlausiException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SporthallenModel {
	private static SporthallenModel instance = null;
	public ArrayList<Sporthalle> sporthallen = new ArrayList<Sporthalle>();

	public void leseSporthallenAusCsvDatei() throws IOException, PlausiException {
		BufferedReader ein = new BufferedReader(new FileReader("Sporthallen.csv"));
		ArrayList<Sporthalle> ergebnis = new ArrayList<>();
		String zeileStr = ein.readLine();
		while (zeileStr != null) {
			String[] zeile = zeileStr.split(";");
			ergebnis.add(new Sporthalle(zeile[0], zeile[1], zeile[2]));
			zeileStr = ein.readLine();
		}
		ein.close();
		this.sporthallen = ergebnis;
	}

	public static SporthallenModel getInstance() {
		if (instance == null)
			instance = new SporthallenModel();
		return instance;
	}
	
	public ArrayList<Sporthalle> getSporthallen(){
		return this.sporthallen;
	}
}

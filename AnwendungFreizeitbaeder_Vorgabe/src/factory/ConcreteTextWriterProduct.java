package factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import business.Freizeitbad;

public class ConcreteTextWriterProduct extends Product {
	
	private BufferedWriter writer;
	
	public ConcreteTextWriterProduct() throws IOException {
		writer = new BufferedWriter(new FileWriter("Freizeitbaeder.txt", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		writer.write("Daten des Freizeitbads\n");
		writer.write("Name des Freizeitbads:\t\t\t\t" + ((Freizeitbad)object).getName() + "\n");
		writer.write("Öffnungszeit des Freizeitbads:\t\t\t\t" + ((Freizeitbad)object).getGeoeffnetVon() + " - " + ((Freizeitbad)object).getGeoeffnetBis() + "\n");
		writer.write("Beckenlänge des Freizeitbads:\t\t\t\t" + ((Freizeitbad)object).getBeckenlaenge() + "\n");
		writer.write("Wassertemperatur des Freizeitbads:\t\t\t\t" + ((Freizeitbad)object).getTemperatur());
	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}
}


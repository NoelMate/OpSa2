package factory;

import java.io.*;
import business.*;

public class ConcreteProduct extends Product {
	private BufferedWriter writer;
	
	public ConcreteProduct() throws IOException {
		writer = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
	}
	
	@Override
	public void fuegeInDateiHinzu(Object object) throws IOException {
		writer.write(((Freizeitbad)object).gibFreizeitbadZurueck(';') + "\n");
	}

	@Override
	public void schliesseDatei() throws IOException {
		writer.close();
	}

}

package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import factory.*;

public class FreizeitbaederModel {
		public Freizeitbad freizeitbad;
		public FreizeitbaederModel() {}
		
		
		
		/*public void schreibeFreizeitbaederInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
			aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
			aus.close();
		}*/
		public void schreibeFreizeitbaederInTxtDatei() throws IOException {
			Creator creator = new ConcreteCreator();
			Product writer = creator.factoryMethod("txt");
			writer.fuegeInDateiHinzu(this.freizeitbad);
			writer.schliesseDatei();
		}
		
		public void schreibeFreizeitbaederInCsvDatei() throws IOException {
			Creator creator = new ConcreteCreator();
			Product writer = creator.factoryMethod("csv");
			writer.fuegeInDateiHinzu(this.freizeitbad);
			writer.schliesseDatei();
		}
		
		private Freizeitbad getFreizeitbad() {
			// TODO Auto-generated method stub
			return freizeitbad;
		}
		
		
}

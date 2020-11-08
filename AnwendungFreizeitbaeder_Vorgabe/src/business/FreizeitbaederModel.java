package business;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import ownUtil.PlausiException;

public class FreizeitbaederModel {
		public Freizeitbad freizeitbad;
		public FreizeitbaederModel() {}
		
		
		
		public void schreibeFreizeitbaederInCsvDatei() throws IOException {
			BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv", true));
			aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
			aus.close();
		}
		private Freizeitbad getFreizeitbad() {
			// TODO Auto-generated method stub
			return freizeitbad;
		}
		
		
}

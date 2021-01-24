package business.businessFrezeitbad;

import java.io.IOException;
import factory.*;
import ownUtil.Observable;
import ownUtil.Observer;

import java.util.*;

public class FreizeitbaederModel implements Observable {
	public ArrayList<Freizeitbad> freizeitbad = new ArrayList<Freizeitbad>();
	private static FreizeitbaederModel instance = null;
	Vector<Observer> observerlist = new Vector<Observer>();

	/*
	 * public void schreibeFreizeitbaederInCsvDatei() throws IOException {
	 * BufferedWriter aus = new BufferedWriter(new FileWriter("Freizeitbaeder.csv",
	 * true)); aus.write(this.getFreizeitbad().gibFreizeitbadZurueck(';'));
	 * aus.close(); }
	 */

	private FreizeitbaederModel() {
	}

	public void schreibeFreizeitbaederInTxtDatei() throws IOException {
		Creator creator = new ConcreteCreator();
		Product writer = creator.factoryMethod("txt");
		for (Freizeitbad fzb : this.freizeitbad)
			writer.fuegeInDateiHinzu(fzb);
		writer.schliesseDatei();
	}

	public void schreibeFreizeitbaederInCsvDatei() throws IOException {
		Creator creator = new ConcreteCreator();
		Product writer = creator.factoryMethod("csv");
		for (Freizeitbad fzb : this.freizeitbad)
			writer.fuegeInDateiHinzu(fzb);
		writer.schliesseDatei();
	}

	public ArrayList<Freizeitbad> getFreizeitbad() {
		return freizeitbad;
	}

	public void addFreizeitbad(Freizeitbad freizeitbad) {
		this.freizeitbad.add(freizeitbad);
	}

	public static FreizeitbaederModel getInstance() {
		if (instance == null) {
			instance = new FreizeitbaederModel();
		}
		return instance;
	}

	@Override
	public void addObserver(Observer obs) {
		observerlist.addElement(obs);
	}

	@Override
	public void removeObserver(Observer obs) {
		observerlist.removeElement(obs);
	}

	@Override
	public void notifyObservers() {
		for (int i = 0; i < observerlist.size(); i++) {
			observerlist.get(i).update();
		}
	}

}

package gui.guiSportstaetten;

import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.*;
import javafx.event.*;
import business.businessFrezeitbad.Freizeitbad;
import business.businessFrezeitbad.FreizeitbaederModel;
import business.businessSporthallen.Sporthalle;
import business.businessSporthallen.SporthallenModel;
import ownUtil.*;

public class SportstaettenView {

	private FreizeitbaederModel freizeitbaederModel;
	private SporthallenModel sporthallenModel;
	private SportstaettenControl sportstaettenControl;

	// ---Anfang Attribute der grafischen Oberflaeche---
	private Pane pane = new Pane();
	private Label lblAnzeigeFreizeitbaeder = new Label("Anzeige Freizeitb�der");
	private Label lblAnzeigeSporthallen = new Label("Anzeige Sporthallen");
	private TextArea txtAnzeigeFreizeitbaeder = new TextArea();
	private TextArea txtAnzeigeSporthallen = new TextArea();
	private Button btnAnzeigeFreizeitbaeder = new Button("Anzeige");
	private Button btnAnzeigeSportstaetten = new Button("Anzeige");
	private MenuBar mnbrMenuLeiste = new MenuBar();
	private Menu mnDatei = new Menu("Datei");
	private MenuItem mnItmCsvImport = new MenuItem("csv-Import");
	// -------Ende Attribute der grafischen Oberflaeche-------

	public SportstaettenView(Stage primaryStage, FreizeitbaederModel freizeitbaederModel,
			SporthallenModel sporthallenModel, SportstaettenControl sportstaettenControl) {
		this.freizeitbaederModel = freizeitbaederModel;
		this.sporthallenModel = sporthallenModel;
		this.sportstaettenControl = sportstaettenControl;
		this.initKomponentenMenue();
		this.initKomponentenSporthallen();
		this.initKomponentenFreizeitbaeder();
		this.initListener();

		Scene scene = new Scene(this.pane, 560, 340);
		primaryStage.setScene(scene);
		primaryStage.setTitle("Anzeige von Sportst�tten");
		primaryStage.show();
	}

	private void initKomponentenMenue() {
		this.mnbrMenuLeiste.getMenus().add(mnDatei);
		this.mnDatei.getItems().add(mnItmCsvImport);
		pane.getChildren().add(mnbrMenuLeiste);
	}

	private void initKomponentenSporthallen() {
		Font font = new Font("Arial", 20);
		lblAnzeigeSporthallen.setLayoutX(20);
		lblAnzeigeSporthallen.setLayoutY(40);
		lblAnzeigeSporthallen.setFont(font);
		lblAnzeigeSporthallen.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeSporthallen);

		txtAnzeigeSporthallen.setEditable(false);
		txtAnzeigeSporthallen.setLayoutX(20);
		txtAnzeigeSporthallen.setLayoutY(90);
		txtAnzeigeSporthallen.setPrefWidth(220);
		txtAnzeigeSporthallen.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeSporthallen);

		btnAnzeigeSportstaetten.setLayoutX(20);
		btnAnzeigeSportstaetten.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeSportstaetten);
	}

	private void initKomponentenFreizeitbaeder() {
		// Label
		Font font = new Font("Arial", 20);
		lblAnzeigeFreizeitbaeder.setLayoutX(310);
		lblAnzeigeFreizeitbaeder.setLayoutY(40);
		lblAnzeigeFreizeitbaeder.setFont(font);
		lblAnzeigeFreizeitbaeder.setStyle("-fx-font-weight: bold;");
		pane.getChildren().add(lblAnzeigeFreizeitbaeder);

		// Textbereich
		txtAnzeigeFreizeitbaeder.setEditable(false);
		txtAnzeigeFreizeitbaeder.setLayoutX(310);
		txtAnzeigeFreizeitbaeder.setLayoutY(90);
		txtAnzeigeFreizeitbaeder.setPrefWidth(220);
		txtAnzeigeFreizeitbaeder.setPrefHeight(185);
		pane.getChildren().add(txtAnzeigeFreizeitbaeder);

		// Button
		btnAnzeigeFreizeitbaeder.setLayoutX(310);
		btnAnzeigeFreizeitbaeder.setLayoutY(290);
		btnAnzeigeSportstaetten.setLayoutX(20);
		btnAnzeigeSportstaetten.setLayoutY(290);
		pane.getChildren().add(btnAnzeigeFreizeitbaeder);
	}

	private void initListener() {
		btnAnzeigeFreizeitbaeder.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				zeigeFreizeitbaederAn();
			}
		});

		btnAnzeigeSportstaetten.setOnAction(e -> {
			zeigeSporthallenAn();
		});

		mnItmCsvImport.setOnAction(e -> {
			this.leseSporthallenAusDatei("csv");
		});
	}

	public void zeigeFreizeitbaederAn() {
		if (freizeitbaederModel.getFreizeitbad() != null) {
			StringBuffer text = new StringBuffer();
			for (Freizeitbad fzb : freizeitbaederModel.freizeitbad)
				text.append(fzb.gibFreizeitbadZurueck(' ') + "\n");
			this.txtAnzeigeFreizeitbaeder.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Bisher wurde kein Freizeitbad aufgenommen!");
		}
	}

	public void zeigeSporthallenAn() {
		if (sporthallenModel.getSporthallen() != null) {
			StringBuffer text = new StringBuffer();
			for (Sporthalle sh : sporthallenModel.sporthallen)
				text.append(sh.gibSporthalleZurueck(' ') + "\n");
			this.txtAnzeigeSporthallen.setText(text.toString());
		} else {
			zeigeInformationsfensterAn("Die Datei enth�lt keine Sporthalle/n!");
		}
	}

	void zeigeInformationsfensterAn(String meldung) {
		new MeldungsfensterAnzeiger(AlertType.INFORMATION, "Information", meldung).zeigeMeldungsfensterAn();
	}

	void zeigeFehlermeldungAn(String fehlertyp, String meldung) {
		new MeldungsfensterAnzeiger(AlertType.ERROR, fehlertyp + "Fehler", meldung).zeigeMeldungsfensterAn();
	}

	void leseSporthallenAusDatei(String typ) {
		sportstaettenControl.leseSporthallenAusDatei(typ);
	}
}

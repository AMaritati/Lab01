package it.polito.tdp.parole;

import it.polito.tdp.parole.model.Parole;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	Parole elenco ;
	boolean result;
    //char c;
    String elenco1;
    long start = System.nanoTime();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnInserisci;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtTime;
    
    @FXML
    private Button btnReset;
    
    @FXML
    private Button btnCancel;

    @FXML
    void doInsert(ActionEvent event) {
    	
    	String ts = txtParola.getText();
    	
        if (elenco.controllaParola(ts) == false) {
        	txtResult.setText("NON HAI INSERITO UNA PAROLA");
        	txtParola.clear();
        	result = true;
        	return;	
        }
    	elenco.addParola(ts);
    	txtParola.clear();
    	long fine = System.nanoTime();
    	String elenco1 ="";
    	for (String s : elenco.getElenco())    //e' possibile farlo con tostring()
    	{                                      // ma posso anche creare una stringa
    		elenco1+=s+ "\n";
    	}
    	txtResult.setText(elenco1);
    	txtTime.setText("TEMPO IMPIEGATO "+ (fine-start) + " ns");

    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    	//txtTime.setText(Long.toString(System.nanoTime()));

    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	
    	elenco.cancel(txtResult.getSelectedText());
    	String risultato = "";
    	
    	for (String s : elenco.getElenco()) {
    		risultato += s + "\n";
    	}
    		
    	txtResult.setText(risultato);
    	
    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnInserisci != null : "fx:id=\"btnInserisci\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtTime != null : "fx:id=\"txtTime\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCancel != null : "fx:id=\"btnCancel\" was not injected: check your FXML file 'Scene.fxml'.";
        elenco = new Parole() ;
    }
}

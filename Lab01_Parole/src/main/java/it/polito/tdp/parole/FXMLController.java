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
	boolean result = true;
    char c;
    String elenco1;

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
    	for(int i=0;i<ts.length();i++){
            c = ts.charAt(i);
            if(!((Character.isLetter(c)))){
                result = false;
            }
        }
        
        if (result == false) {
        	txtResult.setText("NON HAI INSERITO UNA PAROLA");
        	return;
        	
        }
         
    	elenco.addParola(ts);
    	//List<String> elencoO = elenco.getElenco();
    	txtParola.clear();
    	//txtResult.setText(elencoO.toString());
    	String elenco1 ="";
    	for (String s : elenco.getElenco())    //e' possibile farlo con tostring()
    	{                                      // ma posso anche creare una stringa
    		elenco1+=s+ "\n";
    	}
    	txtResult.setText(elenco1);
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtResult.clear();
    	elenco.reset();
    }
    
    @FXML
    void doCancel(ActionEvent event) {
    	
    	for (String s : elenco.getElenco()) {
    		if (txtResult.getSelectedText().equals(s)) {
    			elenco.cancel(s);
    		}
    	}
    	

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

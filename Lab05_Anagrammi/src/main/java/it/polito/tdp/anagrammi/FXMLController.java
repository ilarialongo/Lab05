package it.polito.tdp.anagrammi;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.angrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
 private Model model;
 private String parola;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParola;

    @FXML
    private Button btnCalcolo;

    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;

    @FXML
    private Button btnReset;

    
    @FXML
    void doCalcolo(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	parola=txtParola.getText();
        List <String> corrette= new ArrayList<>();
        List <String> errate= new ArrayList <> ();
        if (parola.length()==0) {
        	txtCorretti.setText("Inserire una parola");
        	txtErrati.setText("Inserire una parola");
        }
        
        try {
        	corrette= this.model.risultatoCorrette(this.model.anagrammi(parola));
        	errate= this.model.risultatoErrate(this.model.anagrammi(parola));
        } catch (IllegalStateException se) {
       		txtCorretti.setText(se.getMessage());
       		txtErrati.setText(se.getMessage());
    		return;
       	}
    	
    	for (String s: corrette) {
    		txtCorretti.appendText(s+"\n");
    	}
    	
    	for (String s: errate) {
    		txtErrati.appendText(s+"\n");
    	}
    	
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();

    }

    @FXML
    void initialize() {
        assert txtParola != null : "fx:id=\"txtParola\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnCalcolo != null : "fx:id=\"btnCalcolo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtCorretti != null : "fx:id=\"txtCorretti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtErrati != null : "fx:id=\"txtErrati\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }

	public void setModel(Model model) {
		this.model= model;

	}
}

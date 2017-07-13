/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giveawaymanager;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JFileChooser;

/**
 *
 * @author Christian
 */
public class FXMLGiveAwayManagerController implements Initializable {
    public ArrayList<String> entries = new ArrayList<>();
    public String path;
    public String fileName;
    public String clearName;
    Function fu = new Function();
    /**
     * Buttons.
     */
    @FXML
    public Button btnPickWinner;
    @FXML
    public Button btnImportList;
    @FXML
    public Button closeButton;
    @FXML
    public Button btnAddEntries;
    /**
     * Textfields.
     */
    public TextField tfClearList;
    /**
     * Label.
     */
    @FXML
    public Label lbNameDeleted;
    @FXML
    public Label lbListImport;
    @FXML
    public Label lbWinner;
    @FXML
    private Label label;
    /**
     * select a list with entryies.
     * @param selectList 
     */
    @FXML
    public void handleFileChooseButtonAction(ActionEvent selectList){
        final JFileChooser fc = new JFileChooser();
        int value = fc.showOpenDialog(null);
        
        if(value == JFileChooser.APPROVE_OPTION){
            path = fc.getSelectedFile().getPath();
            fileName = fc.getSelectedFile().getName();
        }
        fu.fillList(path);
        lbListImport.setText(fileName+" was imported \r"
                + "number of entries: "+fu.entriesF.size());
        System.out.println(path); 
    }
    @FXML 
    public void handleClearListButtonAction(ActionEvent event){
        System.out.println(tfClearList.getText());
        fu.checkName(tfClearList.getText());
        lbNameDeleted.setText("entry with the name: \r"+tfClearList.getText()+" was deleted \r"
                + "new number of entries :"+fu.entriesF.size());
        tfClearList.clear();
        int u =0;
        for (int i = 0; i < fu.entriesF.size(); i++) {
            System.out.println(""+fu.entriesF.get(i));
            u++;
        }
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    @FXML
    public void handleReadListButtonAction(ActionEvent readList){
        
    }
    @FXML
    public void handleTestButtonAction(ActionEvent test){
        fu.getSize(entries, path);
    }
    @FXML
    public void handlePickWinnerButtonAction(ActionEvent pickWinner){
        fu.prepareList(fu.entriesF);
        
        lbWinner.setText(fu.entriesF.get(fu.getWinnerEntry(fu.entriesF.size())));
    }
}

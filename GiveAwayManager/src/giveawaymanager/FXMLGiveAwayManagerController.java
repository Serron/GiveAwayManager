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
    Function fu = new Function();
    
    @FXML
    private Label label;
    @FXML
    private Button btnPickWinner;
    @FXML
    private Button btnImportList;
    @FXML
    public Button closeButton;
    @FXML
    public TextField tfClearList;
    @FXML
    public String clearName;
    
    
    @FXML
    public void handleFileChooseButtonAction(ActionEvent event){
        final JFileChooser fc = new JFileChooser();
        int value = fc.showOpenDialog(null);
        
        if(value == JFileChooser.APPROVE_OPTION){
            path = fc.getSelectedFile().getPath();
        }
        System.out.println(path);
        tfClearList.clear();
    }
    @FXML 
    public void handleClearListButtonAction(ActionEvent event){
        System.out.println(tfClearList.getText());
        fu.checkName(tfClearList.getText(), path);
        int u =0;
        for (int i = 0; i < fu.entriesF.size(); i++) {
            System.out.println(""+fu.entriesF.get(i));
        }
        System.out.println("New list size"+u);
    }
    @FXML
    public void handleCloseButtonAction(ActionEvent event) {
    ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    @FXML
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
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
}

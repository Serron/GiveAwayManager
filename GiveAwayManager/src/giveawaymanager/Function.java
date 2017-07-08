/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giveawaymanager;

import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author Christian
 */
public class Function {
    public ArrayList<String> entriesF = new ArrayList<>();

    public Function(){}
    
/**
 * Teilnehmer werden ermittelt. 
 * 1. Teilnehmer als Liste
 * 2. Namen aussortieren
 */
    
    /**
     * delete entrys from the list
     * @param name 
     */
    public void deleteName(String name){
        
    }
    /**public String getName(){
        FXMLGiveAwayManagerController.tfClearList.getText();
     return
     * @param name}*/
    public void checkName(String name, String path){
        ManageFile manageFile = new ManageFile(new File(path));
        entriesF = manageFile.getContent();
        for(int i = 0; i<= entriesF.size()-1 ; i++){
            if(name.equals(entriesF.get(i))){
                entriesF.remove(i);
                System.out.println("Eintrag gelöscht");
            }else
                System.out.println("Eintrag stimmt nicht überein");
        }
        
    }
    public void getSize(ArrayList entries, String path){
        ManageFile manageFile = new ManageFile(new File(path));
        entries = manageFile.getContent();
        for(int i=0; i<= entries.size()-1;i++){
            System.out.println(i);
        }
    }
}

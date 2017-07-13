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
    public int winner;
    public int rnd;
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
    public void fillList(String path){
        ManageFile manageFile = new ManageFile(new File(path));
        entriesF = manageFile.getContent();
    }
    /**public String getName(){
        FXMLGiveAwayManagerController.tfClearList.getText();
     return
     * @param name}*/
    public void checkName(String name){
        for (int i = 0; i < 10; i++) {
            for(int u = 0; u<= entriesF.size()-1 ; u++){
                if(name.equals(entriesF.get(u))){
                    entriesF.remove(u);
                    //System.out.println("Eintrag gelöscht"+u);
            }
        }
        }

        
    }
    public void getSize(ArrayList entries, String path){
        ManageFile manageFile = new ManageFile(new File(path));
        entries = manageFile.getContent();
        for(int i=0; i<= entries.size()-1;i++){
            System.out.println(i);
        }
    }
    public void prepareList(ArrayList list){
        list.remove(0);
        
    }
    public int getWinnerEntry(int a){
        winner = (int)(Math.random()*a)+1;
        return winner;
    }
    public void addEntries(ArrayList list, String username, int entries){
        for (int i = 0; i < entries; i++) {
            rnd = (int)(Math.random() * list.size());
            list.add(rnd, username);
        }
    }

}

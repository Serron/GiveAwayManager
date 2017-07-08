/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package giveawaymanager;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import org.apache.commons.io.*;
/**
 *
 * @author Christian
 */
public class ManageFile {
    /**
     * create text file.
     */
    /**
     * variables.
     */
    private File txtOut;
    private FileInputStream fileInS;
    private BufferedReader fileReader;
    private BufferedWriter fileWriter;
    /**
     * constructor.
     * @param txtFile
     */
    public ManageFile(File txtFile){
        
        if(txtFile.exists())
        {
            txtOut = txtFile;
        }
        else
            System.out.println("text file does not exist");
         try {
            fileInS = new FileInputStream(txtFile);
            fileReader = new BufferedReader(new InputStreamReader(fileInS));
            fileWriter = new BufferedWriter(new FileWriter(txtFile, true));
        } catch (IOException ex) {
            Logger.getLogger(ManageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * voids.
     */
    /**
     * void to write in file
     * @param inFile
     */
    public void InFile(String inFile){
        try{
            fileWriter = new BufferedWriter(new FileWriter(txtOut, true));
            fileWriter.write(inFile);
            fileWriter.newLine();
            fileWriter.close();
        }catch(IOException ex){
            Logger.getLogger(ManageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      /**
     * Array lists
     * @param inFileList
     */
    public void InFile(ArrayList<String> inFileList){
        inFileList.stream().forEach((s) -> {
            ManageFile.this.InFile(s);
        });
    }
        /**
     * Return content of ONE line.
     * 
     * @param line
     * @return 
     */
    public String getString(String line) {
        String info = "";
        String a;
        updateFile(txtOut);
        try {
            while ((a = fileReader.readLine()) != null) {
                if (a.startsWith(line)) {
                    info = a.replace(line,"").replace("=","");
                    // BlaBla 
                }
            }
            fileReader.close();
        } catch (IOException e) {

        }
        return info;// BlaBla 
    }
        /**
     * Return content of whole file.
     * @return 
     */
    public String getFileContent() {
        String line = null;
        try {
            while ((line = fileReader.readLine()) != null) {
                line = line + System.getProperty("line.separator");
            }
            fileReader.close();
        } catch (IOException e) {

        }
        return line;
    }
        /**
     * overwrite line in file or create new line.
     * @param line
     * @param a 
     */
    public void set(String line, String a) {
        updateFile(txtOut);
        try {
            // Wenn line nicht existiert
            if (!FileUtils.readFileToString(txtOut).contains(line)) {
                fileWriter.newLine();
                fileWriter.write(line + "=" + a);
                fileWriter.close();
            // Wenn line existiert
            } else {
                updateLine(line + "=" + getString(line), line + "=" + a);
            }
        } catch (IOException e) {

        }
    }
        /**
     * close and open.
     * @param file 
     */
    public void updateFile(File file) {
        try {
            this.txtOut = file;
            fileInS = new FileInputStream(file);
            fileReader = new BufferedReader(new InputStreamReader(fileInS));
            fileWriter = new BufferedWriter(new FileWriter(file, true));
        } catch (IOException e) {

        }
    }
        /**
     * für methode set.
     * welche line, welche info
     * @param toUpdate
     * @param updated 
     */
    private void updateLine(String toUpdate, String updated) {
        
        updateFile(txtOut);
        try {
            String line, oldtext = "";

            while ((line = fileReader.readLine()) != null) {
                oldtext += line + System.getProperty("line.separator");
            }
            fileReader.close();
            String newText = oldtext.replace(toUpdate, updated);            
            fileWriter.write(newText);
            fileWriter.close();
        } catch (IOException e) {
        }
    }
       /**
     * delete all in file.
     * 
     */
    public void clearFile(){
        // Variablen
        String hilfe;
        String empty=null;
        updateFile(txtOut);
        try {
            fileWriter.write("");
            fileWriter.flush();
            fileReader.close();
            fileWriter.close();
        } catch (IOException ex) {
            Logger.getLogger(ManageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
{
        
    }
    }
        /**
     * Methode zum Auslesen
     * variablen initialisieren
     * Schleife zum auslesen
     * einzelne Line speichern
     * return / ausgabe 
     * 
     * @return 
     */
    public ArrayList<String> getContent(){
        String line;
        ArrayList<String> list = new ArrayList<>();
        try {
            while((line = fileReader.readLine()) !=null ){
                list.add(line);
            }  
            fileReader.close();
        } catch (IOException ex) {
            Logger.getLogger(ManageFile.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        
        return list;
        
    }
    
    
}

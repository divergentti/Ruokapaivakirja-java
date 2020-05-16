 /**
 * Lukee ja tallentaa tapahtumatiedostosta tiedot taulukkoon / taulukosta.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 0.1alfa
 * SDK alkaen: @since 8.0.73
  */

package ruokapaivakirja;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.LinkedList;

// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class lueTallennaTapahtuma implements Serializable {
   
/** Tiedoston nimi, johon tapahtumat tallennetaan tai luetaan. */    
public static String tiedostoNimi = "./tapahtumat.txt";    
    
/** Tallentaa tapahtumat LinkedListin objekteineen tiedostoon.
     * @param tapahtumat on tapahtumat sisältävä taulukko. */    
public static void tallennaTapahtumat(LinkedList tapahtumat) {
    try {
        FileOutputStream tiedostoTallennus = new FileOutputStream(tiedostoNimi);
        ObjectOutputStream out = new ObjectOutputStream(tiedostoTallennus);
        out.writeObject(tapahtumat);
        out.close();
        tiedostoTallennus.close();
    } //try 
      catch (IOException ex) { } //catch
} //tallennaTuotetiedot   

/** Lukee tapahtumat LinkedListin objekteineen tiedostosta.
     * @return palauttaa levyltä luetun taulukon. */    
public static LinkedList<Tapahtuma> lueTapahtumat() {
    // Tyhjä lista
    LinkedList<Tapahtuma> inTapahtumat = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tiedostoNimi));
        inTapahtumat = (LinkedList<Tapahtuma>) in.readObject(); 
        in.close();
    } //try
    catch(Exception e) {} //catch
    return inTapahtumat;
 } //lueTapahtumat
} //luokka
   

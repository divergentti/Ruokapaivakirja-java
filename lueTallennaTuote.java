package ruokapaivakirja;

/**
 * Lukee ja tallentaa tuotetiedostosta tiedot taulukkoon / taulukosta.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 0.1alfa
 * SDK alkaen: @since 8.0.73
  */
import java.io.*;
import java.util.*;
import java.io.Serializable;
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class lueTallennaTuote implements Serializable {
    
/** Tiedoston nimi, johon tuotteet tallennetaan tai luetaan. */    
public static String tiedostoNimi = "./tuotteet.txt";    
    
/** Tallentaa tuotetiedot LinkedListin objekteineen tiedostoon.
     * @param tuotteet on tuotelistauksen sisältävä taulukko. */    
public static void tallennaTuotetiedot(LinkedList tuotteet) {
    try {
        FileOutputStream tiedostoTallennus = new FileOutputStream(tiedostoNimi);
        ObjectOutputStream out = new ObjectOutputStream(tiedostoTallennus);
        out.writeObject(tuotteet);
        out.close();
        tiedostoTallennus.close();
    } //try 
      catch (IOException ex) { } //catch
} //tallennaTuotetiedot   

/** Lukee tuotetiedot LinkedListin objekteineen tiedostosta.
     * @return palauttaa levyltä luetun taulukon. */    
public static LinkedList<Tuote> lueTuotteet() {
    // Tyhjä lista
    LinkedList<Tuote> inTuotteet = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tiedostoNimi));
        inTuotteet = (LinkedList<Tuote>) in.readObject(); 
        in.close();
    } //try
    catch(Exception e) {} //catch
    return inTuotteet;
 } //lueTuotteet
} //luokka
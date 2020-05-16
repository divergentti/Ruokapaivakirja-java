package ruokapaivakirja;

/**
 * Lukee ja tallentaa tiedot taulukkoon / taulukosta.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 0.1alfa
 * SDK alkaen: @since 8.0.73
  */
import java.io.*;
import java.util.*;
import java.io.Serializable;
import java.nio.file.*;
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class LueTallenna implements Serializable {
/** Tallentaa tiedot LinkedListin objekteineen tiedostoon. 
 * Alkuehdot: taulukko luotuna ja tiedostonimi täyttää OS:n määritykset.
     * @param taulukko on listauksen sisältävä taulukko.
     * @param tiedostoNimi on tiedostonimi jota käsitellään. */    
public static void tallenna(LinkedList taulukko, String tiedostoNimi) {
     /** @param lahde kopioitavan tiedoston lähde. */    
    Path lahde = Paths.get(tiedostoNimi);
    /** Muodostetaan varmuuskopiotiedoston nimi */
    String varmuusTiedosto = tiedostoNimi+".bak";
    /** @param kohde kopioitavan tiedoston kohde. */    
    Path kohde = Paths.get(varmuusTiedosto);
    /** Kopioidaan varmuustiedostoon */
    try { Files.copy(lahde, kohde, StandardCopyOption.REPLACE_EXISTING);} catch (IOException e1) { }
    /** Tallenetaan taulukko objekteineen */
    try {
        FileOutputStream tiedostoTallennus = new FileOutputStream(tiedostoNimi);
        ObjectOutputStream out = new ObjectOutputStream(tiedostoTallennus);
        out.writeObject(taulukko);
        out.close();
        tiedostoTallennus.close();
    } //try 
      catch (IOException ex) { } //catch
} //tallenna

/** Lukee Tuotetiedot LinkedListin objekteineen tiedostosta.
 *  Alkuehdot: tiedoston nimi oltava olemassa ja täytettävä OS:n vaatimukset.
 *  Objektin Tapahtuma konstruktorissa oltava tyhjä konstruktori ilman testaamista!
     * @param tiedostoNimi on tiedostoni josta tuotteet luetaan */
public static LinkedList<Tuote> lueTuotteet(String tiedostoNimi) {
    // Tyhjää lista
    LinkedList<Tuote> inTuotteet = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tiedostoNimi));
        inTuotteet = (LinkedList<Tuote>) in.readObject(); 
        in.close();
    } //try
    catch(Exception e) {} //catch
    return inTuotteet;
 } //lueTuotteet

/** Lukee Tapahtumat LinkedListin objekteineen tiedostosta.
 *  Alkuehdot: tiedoston nimi oltava olemassa ja täytettävä OS:n vaatimukset.
 *  Objektin Tapahtuma konstruktorissa oltava tyhjä konstruktori ilman testaamista!
     * @param tiedostoNimi on tiedostonimi josta tiedot luetaan.
     * @return palauttaa levyltä luetun taulukon. */    
public static LinkedList<Tapahtuma> lueTapahtumat(String tiedostoNimi) {
        // Tyhjää lista
    LinkedList<Tapahtuma> inTapahtuma = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tiedostoNimi));
        inTapahtuma = (LinkedList<Tapahtuma>) in.readObject(); 
        in.close();
    } //try
       catch(Exception e) {} //catch
    return inTapahtuma;   
  } //lueTapahtuma
} //luokka
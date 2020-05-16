package ruokapaivakirja;

/**
 * Lukee ja tallentaa tiedot taulukkoon / taulukosta.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 1.0a
 * SDK alkaen: @since 8.0.73
  */
import java.io.*;
import java.util.*;
import java.io.Serializable;
import java.nio.file.*;
/** Lukee ja tallentaa tiedot taulukkoon / taulukosta kiintolevylle/ltä. */
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class Levytoiminta implements Serializable {
/** Tallentaa tiedot LinkedListin objekteineen tiedostoon. 
 * Alkuehdot: taulukko luotuna ja tiedostonimi täyttää OS:n määritykset.
     * @param taulukko on listauksen sisältävä taulukko.
     * @param tiedostoNimi on tiedostonimi jota käsitellään. */    
public static void tallenna(LinkedList taulukko, String tiedostoNimi) {
     /** @param lahde kopioitavan tiedoston lähde. */    
    Path lahde = Paths.get(tiedostoNimi);
    /** Muodostetaan varmuuskopiotiedoston nimi. */
    String varmuusTiedosto = tiedostoNimi+".bak";
    /** @param kohde kopioitavan tiedoston kohde. */    
    Path kohde = Paths.get(varmuusTiedosto);
    /** Kopioidaan varmuustiedostoon. */
    try { Files.copy(lahde, kohde, StandardCopyOption.REPLACE_EXISTING);} catch (IOException e1) { }
    /** Tallenetaan taulukko objekteineen. */
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
     * @param tiedostoNimi on tiedostoni josta tuotteet luetaan.
     * @return palauttaa levyltä luetun tuotelistan. */
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
     * @return palauttaa levyltä luetun tapahtumalistauksen. */    
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

/** Lukee Henkilöt LinkedListin objekteineen tiedostosta.
 *  Alkuehdot: tiedoston nimi oltava olemassa ja täytettävä OS:n vaatimukset.
 *  Objektin Henkilo konstruktorissa oltava tyhjä konstruktori ilman testaamista!
     * @param tiedostoNimi on tiedostonimi josta tiedot luetaan.
     * @return palauttaa levyltä luetun henkilötaulukon. */    
public static LinkedList<Henkilo> lueHenkilot(String tiedostoNimi) {
        // Tyhjää lista
    LinkedList<Henkilo> inHenkilo = null;
    try {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(tiedostoNimi));
        inHenkilo = (LinkedList<Henkilo>) in.readObject(); 
        in.close();
    } //try
       catch(Exception e) {} //catch
    return inHenkilo;   
  } //lueHenkilot

} //luokka
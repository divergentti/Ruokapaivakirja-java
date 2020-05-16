/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */
package ruokapaivakirja;

/**
 * Ruokapäiväkirja-sovellus. Tämä sovellus on siirrettävissä esimerkiksi 
 * mobiililaitteeseen tai esimerkiksi PDA:lle, joista viivakoodi/RFID voidaan
 * lukea käyttämällä kännykän omia ominaisuuksia. Tekele on Tietojenkäsittely-
 * tieteiden OOP:-kurssiin liittyvä harjoitus, joka oli suppeaksi rajattu.
 * Koodi on tekijänoikeudella suojattu siten, että mikäli haluat hyödyntää, 
 * pyydä kirjallinen lupa ja mainitse koodissasi mistä olet kopioinut.
 * !! Tuotetietojen ja Tapahtumien välisenä relaationa toimii EAN/GTIN-koodi!!
 * !! Henkilötietojen ja Tapahtumien välisenä relattiona toimii henkilönumero !!
 * 
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 1.0a
 * SDK alkaen: @since 8.0.73
  */
import java.io.Serializable;
import java.util.*;
import java.io.*;
import java.text.ParseException;
import javax.swing.JFrame;
/** Ruokapäiväkirjan pääluokka. Tästä luokasta haaraudutaan eri ikkunoihin . */
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable. */
public class Ruokapaivakirja extends JFrame implements Serializable  {
// Globaalit linkedlistat. */
// Taulukko tuotteille, ei saa määritellä datatyyppiä! Timantin välissä olio. */
public static LinkedList<Tuote> tuotteet = new LinkedList<Tuote>();      
// Taulukko tapahtumille, ei saa määritellä datatyyppiä! Timantin välissä olio. */
public static LinkedList<Tapahtuma> tapahtumat = new LinkedList<Tapahtuma>(); 
// Taulukko henkilöille, ei saa määritellä datatyyppiä!  Timantin välissä olio. */
public static LinkedList<Henkilo> henkilot = new LinkedList<Henkilo>(); 
// Tietokantojen nimet polkuineen, välittyy myös tarvittaviin luokkiin. */
public static String  tuotetietokanta = "tuotteet.db";       
public static String tapahtumatietokanta = "tapahtumat.db";
public static String henkilotietokanta = "henkilot.db";   

    /**
     * @param args normaalit argumentit.
     * @throws java.text.ParseException palauttaa virheen.
     */
    public static void main(String[] args) throws ParseException {
     Locale.setDefault(Locale.GERMAN);
    /** Luetaan tietokannat levyltä muistiin tai luodaan tyhjät. */    
    /** Tietokantojen polut ja nimet .*/
    
    /** Tarkistetaan onko tuotetietokanta luotu.*/
     File tuotefile = new File(tuotetietokanta);
         if(tuotefile.exists() && !tuotefile.isDirectory()) { 
           /** Yritetään lukea tuotetiedot levyltä muistiin jos on. */
            tuotteet=Levytoiminta.lueTuotteet(tuotetietokanta);       
      } //tiedoston tarkistus 
         else { //ei ollut, luodaan tyhjä
        AlustaTietokanta.alustaTuoteTietokanta(tuotetietokanta);
          } //else   
    /** Tarkistetaan onko tuotetietokanta luotu.*/
     File tapahtumafile = new File(tapahtumatietokanta);
         if(tapahtumafile.exists() && !tapahtumafile.isDirectory()) { 
           /** Yritetään lukea tuotetiedot levyltä muistiin jos on. */
            tapahtumat=Levytoiminta.lueTapahtumat(tapahtumatietokanta);       
      } //tiedoston tarkistus 
         else { //ei ollut, luodaan tyhjä
        AlustaTietokanta.alustaTapahtumaTietokanta(tapahtumatietokanta);
          } //else   
    /** Tarkistetaan onko henkilötietokanta luotu.*/
     File henkilofile = new File(henkilotietokanta);
         if(henkilofile.exists() && !henkilofile.isDirectory()) { 
           /** Yritetään lukea henkilötiedot levyltä muistiin jos on. */
            henkilot=Levytoiminta.lueHenkilot(henkilotietokanta);       
      } //tiedoston tarkistus 
         else { //ei ollut, luodaan tyhjä
        AlustaTietokanta.alustaHenkiloTietokanta(henkilotietokanta);
          } //else   
//--------------    tietokannat luettu muistiin tai tehty tyhjät ------- //       
        
   /** Käynnistetään ikkunat ja tulkitaan mahdolliset virheet käynnistyksessä. */
   try {
            javax.swing.UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Tuotetiedot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tuotetiedot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tuotetiedot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tuotetiedot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
   
        /** Aloitetaan yhteenvedolla, josta haaraudutaan toisaalle. */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
               new Yhteenveto().setVisible(true);        
            }
        });
  
    } //main
    




} //luokka

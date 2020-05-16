/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */

package ruokapaivakirja;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * Tekijä: @author Jari Hiltunen
 * Versio: @version 1.0a
 * Näyttää tämän päivän, ajan, lisää tai vähentää päiviä annetusta päivämäärästä. 
 */
public class PaivaLaskuri {
    /**
     * @param paivamaara on päivämäärä josta lasketaan päiviä eteen tai taakse.
     * @param paivia on määrä jota lisätään.
     * @return merkkinonon, jossa päivämäärä.
     */
    public static String lisaaPaivia(Date paivamaara, int paivia) {
        Locale.setDefault(Locale.GERMAN);
        Calendar kalenteri = Calendar.getInstance();
        kalenteri.setTime(paivamaara);
        kalenteri.add(Calendar.DATE, paivia); 
        // Formatointi päivämäärälle
          SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
        return (pF.format(kalenteri.getTime()));
    } //lisaaPaivia
    /**
     * @param paivamaara on päivämäärä josta lasketaan päiviä eteen tai taakse.
     * @param paivia on määrä jota lisätään.
     * @return merkkinonon, jossa päivämäärä.
     */
    public static String poistaPaivia(Date paivamaara, int paivia) {
        Locale.setDefault(Locale.GERMAN);
        Calendar kalenteri = Calendar.getInstance();
        kalenteri.setTime(paivamaara);
        kalenteri.add(Calendar.DATE, -paivia); //huomaa miinusmerkki
        // Formatointi päivämäärälle
          SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
        return (pF.format(kalenteri.getTime()));
    } //poistaPaivia
    /** Palauttaa tämän päivän oikein muotoiltuna
     * @return  tämä päivä muodossa pp.kk.vvvv*/
    
    public static String tamaPaiva() {
    // Päivämäärä formaatissa, jolla voi kutsua Tapahtuma-luokkaa
      Date pvm = new Date();
     // Formatointi päivämäärälle
       SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
         String paivamaara = (pF.format(pvm)); 
     return paivamaara;    
    } //tamaPaiva
    
    /**
     * @return kelloaika formaatissa tt:mm:ss
     */
    public static String tamaKelloaika() {
        Locale.setDefault(Locale.GERMAN);
    // Aika formaatissa, jolla voi kutsua Tapahtuma-luokkaa
      Date pvm = new Date();
          // Formatointi kelloajalle
          SimpleDateFormat kF = 
              new SimpleDateFormat ("hh:mm:ss");
          String kelloaika = (kF.format(pvm));  
     return kelloaika;    
    } //tamaKelloaika
    
    /**
     * Muuttaa annetun päivämäärän String-muodosta Date-muotoon
     * @param paivamaara paivamäärä muodossa pp.kk.vvvv
     * @return date muodossa.
     * @throws java.text.ParseException palauttaa virheen.
     */
    public static Date paivaDateksi(String paivamaara) throws ParseException {
    Date paivaDatena = new Date();
        if (paivamaara.length() == 10) {
        // Formatointi päivämäärälle
           SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
         paivaDatena = pF.parse(paivamaara);
        }
     return paivaDatena;    
    } //tamaPaiva
    
    /**
     * Muuttaa annetun päivämäärän Date-muodosta String-muotoon.
     * @param paivamaara paivamäärä Date-muodossa
     * @return päivämäärä pp.kk.vvvv-muodossa
     * @throws java.text.ParseException palauttaa virheen.
     */
    public static String datePaivaksi(Date paivamaara) throws ParseException {
     Locale.setDefault(Locale.GERMAN);
         // Formatointi päivämäärälle
           SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
         String datePaivaksi = pF.format(paivamaara);
     return datePaivaksi;    
    } //tamaPaiva
    
    public static long stringPaivaero(String alkupvm, String loppupvm) throws ParseException  {
      SimpleDateFormat paivanFormaatti = new SimpleDateFormat("dd.MM.yyyy");
      Long paivaErotus=0L;
         Date paiva1 = paivanFormaatti.parse(alkupvm);
         Date paiva2 = paivanFormaatti.parse(loppupvm);
         long erotus = paiva2.getTime() - paiva1.getTime();
          paivaErotus=TimeUnit.DAYS.convert(erotus, TimeUnit.MILLISECONDS);
        return paivaErotus;
     } //stringPaivaero
     
} //luokka
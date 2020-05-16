package ruokapaivakirja;

import java.io.Serializable;
import java.text.SimpleDateFormat;

/**
 * Tapahtumista muodostuu ruokapäiväkirja. Tapahtuman yksilöivä tieto on tapahtumanumero.
 * GTIN-tieto toimii relaationa Tuote-tietoihin. Kelloaika monessa eri muodossa
 * siksi, että voidaan palauttaa tiedot eri näkymiin helpommin.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 1.0a
 * SDK alkaen: @since 8.0.73
 * 
 */
import java.util.*;
/** Tapahtumista muodostuu päiväkirja levylle. */
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class Tapahtuma implements Serializable {
// **********************************
// Tietokentät:
// **********************************
 /** Päivämäärä. Lasketaan Datesta. */ 
 private String paivamaara;
 /** Kelloaika. Lasketaan Datesta.  */    
 private String kello;
 /** Päivämäärä ja aika. Aikavertailuiden vuoksi.  */    
 private Date kelloaika;
 /** Tapahtumanumero on tikit System.currentTimeMillis(). */    
 private Long tapahtumanumero;
 /** GTIN-numero mitä on syöty - linkittyy tällä Tuotetietoon. */ 
 private Long gtin;
 /** Henkilönumero - linkittyy tällä Henkilötietoon. */ 
 private Integer henkilonumero;
 /** Syöty määrä. */ 
 private Double syotymaara;
 /** Mitattu paino, ollessa tyhjä paino on edellinen paino. */ 
 private Double paino;
 /** Huomautuskenttä. */ 
 private String huomautus;
    
// *********************************************
// Alustus olion luonnin yhteydessä: konstruktorit
// *********************************************
 /** * @param inKelloaika Kelloaika muodossa hh:mm:ss.
     * @param inGtin 13-merkkinen GTIN-tieto (viivakoodista).
     * @param inHenkilo henkilönumero.
     * @param inSyotyMaara syöty määrä.
     * @param inPaino mitattu todellinen paino.
     * @param inHuomautus huomautus tapahtumaan. */
 public Tapahtuma(Date inKelloaika, Long inGtin, Integer inHenkilo, Double inSyotyMaara, Double inPaino, String inHuomautus) {
 /* päivämäärän tulee olla muotoa pp.kk.vvvv, kelloajan muotoa hh:mm:ss ja gtin 13 merkkiä Long. */   
Locale.setDefault(Locale.GERMAN);
if (String.valueOf(inGtin).length() == 13) {
// Päivämäärä formaatissa, jolla voi kutsua esim. Tapahtuma-luokkaa
    // Formatointi päivämäärälle
       SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
         this.paivamaara = (pF.format(inKelloaika)); 
    // Aika formaatissa, jolla voi kutsua Tapahtuma-luokkaa
      // Formatointi kelloajalle
          SimpleDateFormat kF = 
              new SimpleDateFormat ("hh:mm:ss");
         this.kello = (kF.format(inKelloaika));  
 this.kelloaika = inKelloaika;
 this.tapahtumanumero = System.currentTimeMillis();
 this.gtin = inGtin;
 this.henkilonumero = inHenkilo;
 this.syotymaara = inSyotyMaara;
 this.paino = inPaino;
 this.huomautus = inHuomautus;
  } //endif
 } //konstruktori   
/* Minimikonstruktori. */
 public Tapahtuma(Date inKelloaika, Long inGtin, Integer inHenkilo) {
// gtin 13 merkkiä Long //
if (String.valueOf(inGtin).length() == 13 && inHenkilo>=0) {
 // Päivämäärä formaatissa, jolla voi kutsua esim. Tapahtuma-luokkaa
    // Formatointi päivämäärälle
       SimpleDateFormat pF = 
          new SimpleDateFormat ("dd.MM.yyyy");
         this.paivamaara = (pF.format(inKelloaika)); 
    // Aika formaatissa, jolla voi kutsua Tapahtuma-luokkaa
      // Formatointi kelloajalle
          SimpleDateFormat kF = 
              new SimpleDateFormat ("hh:mm:ss");
         this.kello = (kF.format(inKelloaika));  
 this.kelloaika = inKelloaika;
 this.tapahtumanumero = System.currentTimeMillis();
 this.gtin = inGtin;
 this.henkilonumero = inHenkilo;
 this.syotymaara = 0.0;
 this.paino = 0.0;
 this.huomautus = "";   
} //endif
 } //end minimikonstruktori
 //** Tiedoston luentaan tarvittu tyhjä konstruktori. */ 
public Tapahtuma() {}
// **********************************
// Havainnointimetodit:
// **********************************
/** @return  1.Palauttaa päivämäärän. */
public String getPaivamaara() {return this.paivamaara; }
/** @return  2.Palauttaa kellon. */
public String getKello() {return this.kello; }
/** @return  3.Palauttaa päivämäärän ja kelloajan. */
public Date getKelloaika() {return this.kelloaika; }
/**  @return 4.Palauttaa tapahtumanumeron. */
public Long getTapahtumanumero() {return this.tapahtumanumero; }
/** @return  5.Palauttaa GTIN:n */
public Long getGtin() {return this.gtin; }
/** @return  6.Palauttaa henkilönumeron. */
public Integer getHenkilonumero() {return this.henkilonumero;}
/**  @return 7.Palauttaa syödyn määrän. */
public Double getSyotymaara() {return this.syotymaara; }
/** @return  8.Palauttaa painon. */
public Double getPaino() {return this.paino; }
/** @return 9.Palauttaa huomautuksen. */
public String getHuomautus() {return this.huomautus; }
@Override 
public String toString() {
return ("\nPäivämäärä: " + this.paivamaara + "\nKelloaika: " + this.kello +
 "\nKello ja päivä: " + this.kelloaika +      
"\nTapahtumanumero: " + this.tapahtumanumero + "\nGTIN: " + this.gtin + 
"\nHenkilönumero: " +this.henkilonumero +
"\nSyöty määrä: "+ this.syotymaara + "\nPaino: " + this.paino +
"\nHuomautus: " +this.huomautus);
} //toString
// **********************************
// Olion muuttaminen: muutosmetodit
// **********************************
/** @param uusiPaivamaara Asettaa uuden päivämäärän. Alkuehto uusiPaivamaara = 10 merkkiä.  */
public void setPaivamaara(String uusiPaivamaara) { 
    if (uusiPaivamaara.length()==10) {this.paivamaara=uusiPaivamaara;} 
    } //set
/** @param uusiKello  Asettaa uuden kellon. Alkuehto uusiKelloaika = 8 merkkiä.  */
public void setKello(String uusiKello) { 
    if (uusiKello.length()==8) {this.kello=uusiKello;} 
    } //set
/** @param uusiKelloaika  Asettaa uuden kelloajan pvm + aika. */
public void setKelloaika(Date uusiKelloaika) { 
    {this.kelloaika=uusiKelloaika;} 
    } //set
/** Asettaa uuden tapahtumanumeron. Funktio. */
public void setTapahtumanumero() { 
     {this.tapahtumanumero=System.currentTimeMillis();} 
    } //set
/** @param uusiGtin Asettaa uuden GTIN:n. Alkuehto uusiGtin = 13 merkkiä.  */
public void setGtin(Long uusiGtin) { 
    if (String.valueOf(uusiGtin).length()==13) {this.gtin=uusiGtin;} 
    } //set
/** @param uusiHenkilonumero Asettaa uuden henkilonumeron. Alkuehto 0 tai enempi. */
public void setHenkilonumero(Integer uusiHenkilonumero) {
    if (uusiHenkilonumero>=0) {this.henkilonumero=uusiHenkilonumero;}
} //set
/** @param uusiSyotymaara Asettaa uuden syödyn määrän:n. Alkuehto yli 0. */
public void setSyotumaara(Double uusiSyotymaara) { 
    if (uusiSyotymaara>0.0) {this.syotymaara=uusiSyotymaara;} 
    } //set
/** @param uusiPaino Asettaa uuden painon. Alkuehto yli 0.  */
public void setPaino(Double uusiPaino) { 
    if (uusiPaino>0) {this.paino=uusiPaino;} 
    } //set
/** @param uusiHuomautus Asettaa uuden huomautuksen. Voi olla tyhjä.  */
public void setHuomautus(String uusiHuomautus) { 
    {this.huomautus=uusiHuomautus;} 
    } //set
} //endclass

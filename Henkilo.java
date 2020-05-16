/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */

package ruokapaivakirja;

import java.io.Serializable;


/**
 * Luo Henkilo-olion, joka pitää sisällään henkilön tiedot. 
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 1.0a
 * SDK alkaen: @since 8.0.73
  */
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class Henkilo implements Serializable  {
// **********************************
// Tietokentät:
// **********************************
/** Henkilön nimi. */
private String henkiloNimi;
/** Henkilön sukupuoli. True mies, False nainen */
private Boolean henkiloSukupuoli;
/** Ikä  vuosina. */
private Integer henkiloIka;
/** Painko kg. Tätä käytetään aloituspainona.*/
private Double henkiloPaino;
/** Pituus cm. */
private Double henkiloPituus;
/** Henkilön aktiivisuustaso. */
private Double henkiloAktiivisuus;
/** Huomautuskenttä mikäli tarvetta lisätä jotain. */
private String henkiloHuomautus;
/** Kenttä jonka avulla kerrotaan onko henkilö aktiivinen vai ei (varaus). */
private Boolean henkiloAktiivinen;
/** Henkilönumero. Generoidaan taulun koosta. Toimii relaationa! */
private Integer henkiloNumero;
// *********************************************
// Alustus olion luonnin yhteydessä: konstruktorit
// *********************************************
/** Luo olio per henkilötiedot
     * @param inHenkiloNimi 1.Henkilön koko nimi.
     * @param inHenkiloSukupuoli 2.Henkilön sukupuoli, false=mies.
     * @param inHenkiloIka 3.Henkillön ikä.
     * @param inHenkiloPaino 4.Henkilön paino.
     * @param inHenkiloPituus 5.Henkilön pituus.
     * @param inHenkiloAktiivisuus 6.Aktiivisuuskerroin.
     * @param inHenkiloHuomautus 7.Huomautuskenttä.
     * @param inHenkiloAktiivinen 8.Onko henkilö asetettu poistetuksi.
     * @param inHenkiloNumero 9. Henkilönumero*/

public Henkilo(String inHenkiloNimi, Boolean inHenkiloSukupuoli, Integer inHenkiloIka, Double inHenkiloPaino, Double inHenkiloPituus,
        Double inHenkiloAktiivisuus, String inHenkiloHuomautus, Boolean inHenkiloAktiivinen, Integer inHenkiloNumero) {
// Luodaan vain jos nimi on yli 2, paino ja aktiivuus määritelty.
if (String.valueOf(inHenkiloNimi).length() >2 && inHenkiloIka>0 
        && inHenkiloPaino>0 && inHenkiloPituus>0.0 
        && inHenkiloAktiivisuus>0.0 && inHenkiloNumero>=0) {    
 this.henkiloNimi = inHenkiloNimi; 
 this.henkiloSukupuoli = inHenkiloSukupuoli;
 this.henkiloIka = inHenkiloIka; 
 this.henkiloPaino = inHenkiloPaino;
 this.henkiloPituus = inHenkiloPituus;
 this.henkiloAktiivisuus = inHenkiloAktiivisuus;
 this.henkiloHuomautus = inHenkiloHuomautus;
 this.henkiloAktiivinen = inHenkiloAktiivinen;
 this.henkiloNumero = inHenkiloNumero;
} //endif
} // Konstruktori
//** Tiedoston luentaan tavittu tyhjä konstruktori */
public Henkilo() {}
// **********************************
// Havainnointimetodit:
// **********************************
/** @return Palauttaa henkilön nimen. */
public String getNimi() { return this.henkiloNimi; }
/** @return Palauttaa henkilön sukupuolen. */
public Boolean getSukupuoli() { return this.henkiloSukupuoli; }
/**@return Palauttaa henkilön iän. */
public Integer getIka() { return this.henkiloIka; }
/**@return Palauttaa henkilön painon.  */
public Double getPaino() { return this.henkiloPaino; }
/**@return Palauttaa henkilön pituuded.  */
public Double getPituus() { return this.henkiloPituus; }
/**@return Palauttaa henkilön aktiivisuuden. */
public Double getAktiivisuus() { return this.henkiloAktiivisuus; }
/** @return Palauttaa henkilön huomautuksen. */
public String getHuomautus() { return this.henkiloHuomautus; }
/** @return Palauttaa tiedon onko henkilö aktivoitu vai ei.  */
public Boolean getOnkoAktiivinen() { return this.henkiloAktiivinen; }
/** @return Palauttaa henkilönumeron.  */
public Integer getHenkiloNumero() { return this.henkiloNumero; }
/** Palauttaa kaikki tiedot sisältävän merkkijonon, jota voidaan käyttää esim. tulostuksessa
     * @return Palauttaa tulostettavat yhdessä. */
@Override 
public String toString() {
return ("\nNimi: " + this.henkiloNimi + "\nSukupuoli: "+this.henkiloSukupuoli+"\nIkä: " + this.henkiloIka +
"\nPaino: " + this.henkiloPaino + "\nPituus: " + this.henkiloPituus +"\nAktiivisuuskerroin: " + this.henkiloAktiivisuus +
"\nHuomautus: "+ this.henkiloHuomautus + "\nVoimassa: " + this.henkiloAktiivinen + "\nHenkilönumero: " + this.henkiloNumero);
} //toString
// **********************************
// Olion muuttaminen: muutosmetodit
// **********************************
/** @param uusiNimi Asettaa uuden nimen. Alkuehto uusiNimi yli 0 merkkiä.   */
public void setNimi(String uusiNimi) { 
    if (uusiNimi.length()>0) {this.henkiloNimi=uusiNimi;}
} //set
/** @param uusiSukupuoli  Asettaa uuden sukupuolen.  */
public void setSukupuoli(Boolean uusiSukupuoli) { 
    {this.henkiloSukupuoli=uusiSukupuoli;}
} //set
/** @param uusiIka Asettaa uuden iän. Alkuehto yli 0.  */
public void setIka(Integer uusiIka) { 
    if (uusiIka>0) {this.henkiloIka=uusiIka;}
} //set
/**  @param uusiPaino  Asettaa uuden painon. Alkuehto yli 0. */
public void setPaino(Double uusiPaino) { 
    if (uusiPaino>0.0) {this.henkiloPaino=uusiPaino;}
} //set
/** @param uusiPituus   Asettaa uudenpituuden. Alkuehto yli 0. */
public void setPituus(Double uusiPituus) { 
    if (uusiPituus>0.0) {this.henkiloPituus=uusiPituus;}
} //set
/** @param uusiAktiivisuusKerroin Asettaa uuden aktiivisuuskertoimen. Alkuehto yli 0.  */
public void setAktiivisuusKerroin(Double uusiAktiivisuusKerroin) { 
    if (uusiAktiivisuusKerroin>0.0) {this.henkiloAktiivisuus=uusiAktiivisuusKerroin;}
} //set
/**  @param uusiHuomautus Asettaa huomautuksen.  Voi olla tyhjä. */
public void setHuomautus(String uusiHuomautus) { 
    this.henkiloHuomautus = uusiHuomautus;
} //set
/** @param uusiAktivaatio Asettaa henkilön aktiiviseksi tai inaktiiviseksi.  Alkuehto boolean.  */
public void setAktivointi(Boolean uusiAktivaatio) { 
      {this.henkiloAktiivinen=uusiAktivaatio;}
} //set
// Henkilönumeroa käytetään relaatiossa, jota ei saa muuttaa!
} //class 
package ruokapaivakirja;

import java.io.Serializable;

/**
 * Luo Tuote-olion, joka pitää sisällään tuotteen tiedot viivakoodeideen, 
 * energiasisältöineen ja ravinto-aineineineen.
 * Tuote-oliot voidaan lukea suoraan tiedostosta kutsumalla tätä luokkaa.
 * Tuote-olion tunniste on GTIN-tunniste.
 * Tekijä:     @author Jari Hiltunen
 * Versio:     @version 1.0a
 * SDK alkaen: @since 8.0.73
  */
// Jokaisessa luokassa, josta tallennetaan, tulee olla implements Serializable
public class Tuote implements Serializable  {
// **********************************
// Tietokentät:
// **********************************
/** 13-merkkinen EAN/GTIN koodi, joka toimii myös primääriavaimena kaikille tapahtumille
 *  Tuotetta ei saa koskaan poistaa, sillä tapahtumat voivat viitata tuotteeseen.
 *  Tyyppinä long siksi, ettei Integerissä riittäsi pituus */
private Long gtin;    
/** Tuotteen nimi */
private String tuoteNimi;
/** Tuotteen sisältämä energia, yksikkönä KCAL */
private Double energia;
/** Yksikkö per energia - per 100g, per kpl tai per annos */
private String yksikko;
/** Tuotteen sisältö aina Proteiini-Hiilih.-Rasva-jaotteluna:
    Tuotteen sisältämä proteiinimäärä grammoissa */
private Double proteiini;
/** Tuotteen sisältämä hiilihydraattimäärä grammoissa */
private Double hiilihydraatti;
/** Tuotteen sisältämä rasvamäärä grammoissa */
private Double rasva;
/** Huomautuskenttä mikäli tarvetta lisätä jotain */
private String huomautus;
/** Kenttä jonka avulla kerrotaan onko tuote aktiivinen vai ei */
private Boolean aktiivinen;
// *********************************************
// Alustus olion luonnin yhteydessä: konstruktorit
// *********************************************
/** Luo tuote, jonka GTIN on iNgtin, tuotenimi on tuotenimi jne
     * @param inGtin 1.13-merkkinen GTIN-tieto (viivakoodista).
     * @param inTuoteNimi 2.tuotteen nimi.
     * @param inEnergia 3.tuotteen sisältämä koknaisenergia.
     * @param inYksikko 4.yksikkö energialle, per 100g, kpl tai annoskoko.
     * @param inProteiini 5.tuotteen sisältämä proteiini.
     * @param inHiilihydraatti 6.tuotteen sisältämä hiilihydraatti
     * @param inRasva 7.tuotteen sisältämä rasva 
     * @param inHuomautus 8.tuotteeseen liittyvä huomautus 
     * @param inAktivoitu 9.onko tuote aktviininen vai ei */
public Tuote(Long inGtin, String inTuoteNimi, Double inEnergia,
        String inYksikko, Double inProteiini, Double inHiilihydraatti,
        Double inRasva, String inHuomautus, Boolean inAktivoitu) {
// Luodaan vain jos gtin on 13 merkkiä ja nimi ei ole tyhjä!    
if (String.valueOf(inGtin).length() == 13 && inTuoteNimi.length()>0) {    
 this.gtin = inGtin; 
 this.tuoteNimi = inTuoteNimi; 
 this.energia = inEnergia;
 this.yksikko = inYksikko;
 this.proteiini = inProteiini;
 this.hiilihydraatti = inHiilihydraatti;
 this.rasva = inRasva;
 this.huomautus = inHuomautus;
 this.aktiivinen = inAktivoitu;
} //endif
} // Konstruktori

//** luo Tuote, jossa on nimimimäärä tietoja
public Tuote(Long inGtin, String inTuoteNimi) {
// Luodaan vain jos gtin on 13 merkkiä ja nimi ei ole tyhjä!    
  if (String.valueOf(inGtin).length() == 13 && inTuoteNimi.length()>0) {    
    this.gtin = inGtin;
    this.tuoteNimi = inTuoteNimi;
    this.energia = 0.0;
    this.yksikko = "/100";
    this.proteiini = 0.0;
    this.hiilihydraatti = 0.0;
    this.rasva = 0.0;
    this.huomautus ="";
    this.aktiivinen = true;
  } //endif   
} //minimikonstruktori
//** Tiedoston luentaan tavittu tyhjä konstruktori 
public Tuote() {}
// **********************************
// Havainnointimetodit:
// **********************************
/** @return 1.Palauttaa tuotteen gtin:n. */
public Long getGtin() { return this.gtin; }
/** @return  2.Palauttaa tuotteen nimen. */
public String getTuoteNimi() { return this.tuoteNimi; }
/** @return  3.Palauttaa tuotteen energian.*/
public Double getEnergia() { return this.energia; }
/** @return 4.Palauttaa tuotteen yksikön. */
public String getYksikko() { return this.yksikko; }
/** @return 5.Palauttaa tuotteen proteiinit. */
public Double getProteiini() { return this.proteiini; }
/** @return 6.Palauttaa tuotteen hiilihydraatit. */
public Double getHiilihydraatti() { return this.hiilihydraatti; }
/** @return 7.Palauttaa tuotteen rasvan.*/
public Double getRasva() { return this.rasva; }
/** @return 8.Palauttaa tuotteen huomautuksen. */
public String getHuomautus() { return this.huomautus; }
/** @return 9.Palauttaa tiedon onko aktviinen vai ei. */
public Boolean getAktivointi() { return this.aktiivinen; }
/** @return Palauttaa tulostettavat yhdessä pötkössä. */
@Override 
public String toString() {
return ("\nGTIN: " + this.gtin + "\nTuote: " + this.tuoteNimi +
"\nEnergia: " + this.energia + "\nYksikkö: " + this.yksikko +
"\nProteiini: "+ this.proteiini + "\nHiilihydraatti: " + this.hiilihydraatti +
"\nRasva: " +this.rasva + "\nHuomautus: " + this.huomautus + "\nAktiivinen: " + this.aktiivinen);
} //toString
// **********************************
// Olion muuttaminen: muutosmetodit
// **********************************
/** Huom! GTIN on primääriavain ja sitä EI saa muuttaa eikä poistaa! */
/**@param uusiTuoteNimi Asettaa uuden tuotenimen. Alkuehto uusiTuotenimi yli 0 merkkiä. */
public void setTuoteNimi(String uusiTuoteNimi) { 
    if (uusiTuoteNimi.length()>0) {this.tuoteNimi=uusiTuoteNimi;}
} //set
/** @param uusiEnergia Asettaa uuden energian. Alkuehto uusiEnergia yli 0 merkkiä.  */
public void setEnergia(Double uusiEnergia) { 
    if (String.valueOf(uusiEnergia).length()>0) {this.energia=uusiEnergia;}
} //set
/** @param uusiYksikko  Asettaa uuden yksikön. Alkuehto uusiYksikko yli 0 merkkiä.  */
public void setYksikko(String uusiYksikko) { 
    if (uusiYksikko.length()>0) {this.yksikko=uusiYksikko;}
} //set
/** @param uusiProteiini  Asettaa uuden proteiinitiedon. Alkuehto uusiProteiini yli 0 merkkiä.  */
public void setProteiini(Double uusiProteiini) { 
    if (String.valueOf(uusiProteiini).length()>0) {this.proteiini=uusiProteiini;}
} //set
/** @param uusiHiilihydraatti  Asettaa uuden hiilihydraattiiedon.  Alkuehto uusiHiilihydraatti yli 0 merkkiä.  */
public void setHiilihydraatti(Double uusiHiilihydraatti) { 
    if (String.valueOf(uusiHiilihydraatti).length()>0) {this.hiilihydraatti=uusiHiilihydraatti;}
} //set
/** @param uusiRasva Asettaa uuden rasvatiedon.  Alkuehto uusiRasvatieto yli 0 merkkiä.    */
public void setRasva(Double uusiRasva) { 
    if (String.valueOf(uusiRasva).length()>0) {this.rasva=uusiRasva;}
} //set
/** @param uusiHuomautus Asettaa uuden huomautustiedon.  Alkuehto uusiHuomautus voi olla null.   */
public void setHuomautus(String uusiHuomautus) { 
    {this.huomautus=uusiHuomautus;}
} //set
/** @param uusiAktivaatio  Asettaa tuotteen aktiiviseksi tai inaktiiviseksi.  Alkuehto boolean.  */
public void setAktivointi(Boolean uusiAktivaatio) { 
      {this.aktiivinen=uusiAktivaatio;}
} //set
} //class 

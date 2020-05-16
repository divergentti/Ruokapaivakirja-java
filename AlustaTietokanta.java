/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */

package ruokapaivakirja;

/**
 * Tekijä: @author Jari Hiltunen
 * Versio: @version 1.0a
 * SDK alkaen: @since 8.0.73
 * Tekee tyhjän tietokannan jossa esimerkit inaktiivisina.
 */

// Tuodaan tarvittavat taulut. */
import java.io.Serializable;
import java.util.Date;
import static ruokapaivakirja.Ruokapaivakirja.tuotteet;
import static ruokapaivakirja.Ruokapaivakirja.tapahtumat;
import static ruokapaivakirja.Ruokapaivakirja.henkilot;
/** Tekee tyhjän tietokannan jossa esimerkit inaktiivisina. */    

public class AlustaTietokanta  implements Serializable {
/** Tämä tehdään ensimmäisellä kerralla tai jos tietokantaa ei löydy.
     * @param tietokanta on tietokannan polku ja nimi */
    public static void alustaTuoteTietokanta(String tietokanta) {
/** Alustetaan tietokannat esimerkkidatalla.  */    
/** Tuoteolioiden luominen. Huomaa relaatio EAN/GTIN-koodiin!. **/
  Tuote L1234567890123 = new Tuote(1234567890123L, "Mallituote", 0.0, "kpl",
  0.0, 0.0, 0.0,"Tietokannan alustustuote",false);
/** Tyhjennetään varmuuden vuoksi taulukko. */  
 tuotteet.clear();
/** Olioiden tallentaminen tauluun. */
 tuotteet.add(L1234567890123);
 Levytoiminta.tallenna(tuotteet, tietokanta);
   } //alustaTuoteTietokanta
    
/** Tämä tehdään ensimmäisellä kerralla tai jos tietokantaa ei löydy.
     * @param tietokanta on tietokannan polku ja nimi */    
 public static void alustaTapahtumaTietokanta(String tietokanta) {
 /** Tapahtumien alustus. Huomaa relaatio EAN/GTIN-koodiin!. */
 tapahtumat.clear();
 /** Malli Malliselle tapahtuma (henkilonumero 1). */
 Date pvm = new Date();
 Tapahtuma esimerkki = new Tapahtuma(pvm, 1234567890123L, 1, 55.0, 75.5, "Esimerkkidata");
 tapahtumat.add(esimerkki);
 Levytoiminta.tallenna(tapahtumat, tietokanta);
 /** Tiedot tässä vaiheessa tallennettu ja esimerkkidatalla valitut tiedot tallennettu. */
  } //alustaTapahtumaTietokanta
 
/** Tämä tehdään ensimmäisellä kerralla tai jos tietokantaa ei löydy.
     * @param tietokanta on tietokannan polku ja nimi */    
 public static void alustaHenkiloTietokanta(String tietokanta) {
 /** Alustus.  */
 henkilot.clear();
 /** Henkilönumero on 0 ja voidaan jättää listauksista pois, seuraavat ovat taulun koko + 1 */
 Henkilo esimerkki1 = new Henkilo("Malli Mallinen",false, 47, 78.0, 180.0, 1.55, "Esimerkkidata", false, 1);
 henkilot.add(esimerkki1);
 Henkilo esimerkki2 = new Henkilo("Neiti Mallinen",true, 27, 58.0, 160.0, 1.9, "Esimerkkidata nainen", false, 2);
 henkilot.add(esimerkki2);
 Levytoiminta.tallenna(henkilot, tietokanta);
 /** Tiedot tässä vaiheessa tallennettu ja esimerkkidatalla valitut tiedot tallennettu. */
  } //alustaTapahtumaTietokanta
} //luokka


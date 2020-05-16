/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */

package ruokapaivakirja;

/**
 * Tekijä: @author Jari Hiltunen
 * Versio: @version 1.0a
 * Laskee WHO:n mukaisen energiaennusteen.
 */
public class Energia {


/** Metodi palauttaa ennusteBMR:n KCAL eli ns koomakulutuksen.
     * @param paino Henkilön paino kg desimaaliluku.   
     * @param pituus Pituus cm, desimaaliluku.   
     * @param ika  Ikä, kokonaisluku.  
     * @param sukupuoli Sukupuoli, boolean.   
     * @return ennusteBMR. */    
public static Double ennusteBMR (Double paino, Double pituus, int ika, boolean sukupuoli) {
if (sukupuoli==false) {
    //ennuste miehelle
    return 66.0+(13.7*paino)+(5*pituus)-(6.8*ika);
} else {
    //ennuste naiselle
    return 655.0+(0.6*paino)+(1.8*pituus)-(4.7*ika);
} //else
} //ennusteMBR

/** Metodi palauttaa ennusteKokonaiskulutuksen KCAL aktiivisuuden mukaisesti. 
 * @param paino Henkilön paino kg desimaaliluku.   
 * @param pituus Pituus cm, desimaaliluku.   
 * @param ika  Ikä, kokonaisluku.  
 * @param sukupuoli Sukupuoli, boolean.   
 * @param aktiivisuus Aktiivisuuskerroin makaa sängyssä - Duracell.   
 * @return ennusteKokonaisKulutus. */  
public static Double ennusteKokonaisKulutus (Double paino, Double pituus, int ika, boolean sukupuoli, Double aktiivisuus) {
if (sukupuoli==false) {
  //ennuste mies
  return aktiivisuus*(66.0+(13.7*paino)+(5*pituus)-(6.8*ika));  
} else {
  //ennuste nainen  
    return aktiivisuus*(655.0+(9.6*paino)+(1.8*pituus)-(4.7*ika));  
 } //else 
 } //ennusteKokonaisKulutus
} //luokka
        

/*
 *  Tekijä: Jari Hiltunen, Hanko, Finland.
 *  Location: KO19LU (maidenhead).
 *  Free to reuse/distribute with written permission by the author.
 */

package ruokapaivakirja;

/** KESKEN!
 * Tekijä: @author Jari Hiltunen
 * Versio: @version 1.0a
 * Listaa aktiiviset tai inaktiiviset tuotteet.
 */ 

import java.util.*;
import static ruokapaivakirja.Ruokapaivakirja.tuotteet;
public class ListaaTuotteet {

/** Metodi listaa kaikki objektit, jotka ovat aktiivisia
     * @param tuotteet Tuotelista. */    
public static void listaaAktiiviset(LinkedList<Tuote> tuotteet) {   
    /** Tulostetaan lista tuotteista. */
    for (Tuote e : tuotteet) {
      if ((e.getAktivointi().booleanValue()==true)) {
      // koodia    
      }//if
    } //for 
  } //ListaaAktiiviset
/** Metodi listaa kaikki objektit, jotka ovat inaktiivisia
     * @param tuotteet Tuotelista. */    
public static void listaaInAktiiviset(LinkedList<Tuote> tuotteet) {   
    /** Tulostetaan lista tuotteista. */
    for (Tuote e : tuotteet) {
      if ((e.getAktivointi().booleanValue()==false)) {
      //    System.out.print("EAN/GTIN: "+e.getGtin()+": "+e.getTuoteNimi()+"\n");
      }//if
    } //for 
  } //ListaaAktiiviset
} //luokka

package sk.uniza.fri.wof.hra;

/**
 * Trieda prikaz implemntuje casti prikazu, ktore moze hrac zadat.
 * V tejto verzii prikaz tvoria dve slova: nazov prikazu a druhe slovo.
 * Napriklad prikaz "chod juh" tvoria dva retazce "chod" ako nazov prikazu a
 * "juh" ako oznacenie smeru.
 * 
 * Predpoklada sa, ze prikaz je skontrolovany, t.j., ze nazov prikazu je znamy.
 * Pre neznamy prikaz je jeho nazov nastaveny na hodnotu <null>.
 *
 * Ak prikaz nema parameter, potom ma druhe slovo hodnotu <null>.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */

public class Prikaz {
    private String nazovPrikazu;
    private String[] parametere;

    /**
     * Inicializuje slova prikazu dvomi zadanymi parametrami. Jeden alebo oba
     * parametre mozu mat hodnotu <null>.

     * @param nazovPrikazu prve slovo - nazov prikazu, 
     *                       null, ak je prikaz neznamy.
     * @param parameter druhe slovo prikazu.
     */
    public Prikaz(String nazovPrikazu, String[] parametere) {
        this.nazovPrikazu = nazovPrikazu;
        this.parametere = parametere;
    }

    /**
     * @return prve slovo - nazov prikazu.
     */
    public String getNazov() {
        return this.nazovPrikazu;
    }

    /**
     * @return druhe slovo - parameter prikazu.
     */
    public String getParameter() {
        return this.getParameter(0);
    }
    
    public String getParameter(int poradie) {
        return this.parametere.length > poradie ? this.parametere[poradie] : null;
    }

    /**
     * @return true, ak je prikaz neznamy.
     */
    public boolean jeNeznamy() {
        return this.nazovPrikazu == null;
    }

    /**
     * @return true, ak prikaz ma parameter.
     */
    public boolean maParameter() {
        return this.getParameter() != null;
    }
}

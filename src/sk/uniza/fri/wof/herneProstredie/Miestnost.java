package sk.uniza.fri.wof.herneProstredie;


import java.util.ArrayList;
import java.util.HashMap;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Miestnost {
    private String popisMiestnosti;
    private HashMap<String, IDvere> zoznamDveri;
    private HashMap<String, IPredmet> predmety;
    private final String nazov;
            
    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */
    public Miestnost(String nazov, String popis) {
        this.popisMiestnosti = popis;
        this.nazov = nazov;
        this.zoznamDveri = new HashMap<String, IDvere>();
        this.predmety = new HashMap<String, IPredmet>();
    }   

    /*public void nastavVychod(Miestnost druhaMiestnost) {
        this.susedneMiestnosti.put(druhaMiestnost.getNazov(), druhaMiestnost);
    }*/
    
    public void pridajPredmet(IPredmet predmet) {
        this.predmety.put(predmet.getNazov(), predmet);
    }
    
    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public String getNazov() {
        return nazov;
    }

    public void vypisInfoOMiestnosti() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (String vychod : this.zoznamDveri.keySet()) {
            System.out.print(vychod+" ");
        }
        System.out.println();
    }

    public IDvere dajDverePodlaSmeru(String smer) {
        return this.zoznamDveri.get(smer);
    }

    public void vypisPredmety() {
        System.out.println("Predmety v miestnosti: ");
        for (String predmet : this.predmety.keySet()) {
            System.out.print(predmet+" ");
        }
        System.out.println("");
    }

    public IPredmet zoberPredmet(String nazov) {
        return this.predmety.remove(nazov);
    }

    public void nastavDvere(String nazov, IDvere dvere) {
        this.zoznamDveri.put(nazov, dvere);
    }

    public ArrayList<IDvere> dajDvere() {
        return new ArrayList<IDvere>(this.zoznamDveri.values());
    }

    public ArrayList<IPredmet> dajPredmety() {
        ArrayList<IPredmet> predmety = new ArrayList<>();
        for (IPredmet predmet : this.predmety.values()) {
            predmety.add(predmet);
        }
        return predmety;
    }

    public IPredmet dajPredmet(String parameter) {
        return this.predmety.get(parameter);
    }

    public void odstranDvere(String dvere) {
        this.zoznamDveri.remove(dvere);
    }

    
}

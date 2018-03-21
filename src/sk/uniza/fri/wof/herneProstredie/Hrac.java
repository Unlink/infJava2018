package sk.uniza.fri.wof.herneProstredie;


import sk.uniza.fri.wof.hra.Prikaz;
import java.util.HashMap;
import sk.uniza.fri.wof.herneProstredie.npc.INpc;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class Hrac {
    
    private Miestnost aktualnaMiestnost;
    private HashMap<String, IPredmet> inventar;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
    }
    
    /** 
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    public void chodDoMiestnosti(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = prikaz.getParameter();

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        IDvere dvere = this.aktualnaMiestnost.dajDverePodlaSmeru(smer);

        if (dvere == null) {
            System.out.println("Tam nie je vychod!");
        } else if (!dvere.suPrechodne(aktualnaMiestnost)) {
            System.out.println("Dvere su zatvorene!");
        } 
        else {
            this.aktualnaMiestnost = dvere.dajDruhuMiestnost(aktualnaMiestnost);
            this.aktualnaMiestnost.vypisInfoOMiestnosti();
        }
    }

    public Miestnost getAktualnaMiestnost() {
        return this.aktualnaMiestnost;
    }
    
    public void zodvihniPredmet(String nazov) {
        IPredmet predmet = this.aktualnaMiestnost.zoberPredmet(nazov);
        if (predmet == null) {
            System.out.println("Takyto predmet sa v miestnosti nenachadza");
        }
        else if (!predmet.daSaZdvihnut()) {
            //Pridame predmet spat do miestnosti
            this.aktualnaMiestnost.pridajPredmet(predmet);
            System.out.println("Tento predmet nieje mozne zodvihnut");
        }
        else {
            
            this.inventar.put(predmet.getNazov(), predmet);
            System.out.println("Zobral si predmet "+predmet.getNazov());
        }
    } 
    
    public void polozPredmet(String nazov) {
        IPredmet predmet = this.inventar.get(nazov);
        if (predmet == null) {
            System.out.println("Takyto predmet nemas v inventári");
        }
        else {
            this.aktualnaMiestnost.pridajPredmet(predmet);
            System.out.println("Polozil si predmet "+predmet.getNazov());
        }
    }

    public void preskumaj(String nazov) {
        if (nazov == null) {
            this.aktualnaMiestnost.vypisPredmety();
        }
        else {
            if (this.inventar.containsKey(nazov)) {
                System.out.println("predmet nieje v inventari");
            }
        }
    }

    public void pouzi(Prikaz prikaz) {
        IPredmet predmet = this.inventar.get(prikaz.getParameter(0));
        if (predmet == null) {
            System.out.println("Takyto predmet nemas");
            return;
        }
        
        predmet.pouzi(this, prikaz.getParameter(1));
    }

    public void interakciaSNpc(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("A s akym?");
            return;
        }
        INpc npc = this.aktualnaMiestnost.getNpc(prikaz.getParameter());
        npc.interakcia(this, prikaz.getParameter(1));
    }

    public void pridajPredmet(IPredmet predmet) {
       this.inventar.put(predmet.getNazov(), predmet);
    }
}

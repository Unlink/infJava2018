package sk.uniza.fri.wof.herneProstredie;


import java.util.ArrayList;
import sk.uniza.fri.wof.hra.Prikaz;
import java.util.HashMap;
import sk.uniza.fri.wof.herneProstredie.npc.INpc;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;
import sk.uniza.fri.wof.questy.NajdiSekeru;
import sk.uniza.fri.wof.questy.Quest;

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
    private ArrayList<Quest> questy;

    public Hrac(Miestnost aktualnaMiestnost) {
        this.aktualnaMiestnost = aktualnaMiestnost;
        this.inventar = new HashMap<>();
        this.questy = new ArrayList<>();
        
        NajdiSekeru quest = new NajdiSekeru();
        this.pridajQuest(quest);
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
            this.skontrolujQuesty();
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
        if (npc == null) {
            System.out.println("Take NPC tu nieje?");
            return;
        }
        
        npc.interakcia(this, prikaz.getParameter(1));
    }

    public void pridajPredmet(IPredmet predmet) {
       this.inventar.put(predmet.getNazov(), predmet);
    }

    public boolean maPredmet(String predmet) {
        return this.inventar.containsKey(predmet);
    }
    
    public void pridajQuest(Quest quest) {
        this.questy.add(quest);
        quest.akceptuj(this);
    }

    public void vypisQuesty() {
        if (!this.questy.isEmpty()) {
            System.out.println("Zoznam tvojich questov:");
            for (Quest quest : this.questy) {
                System.out.println(quest.getPopis());
            }
        }
        else {
            System.out.println("Nemas co robit, skus si najst nejaky quest");
        }
    }

    private void skontrolujQuesty() {
        for (Quest quest : this.questy) {
            if (quest.jeAktivny()) {
                quest.skontrolujCiSplneny(this);
            }
        }
    }
}

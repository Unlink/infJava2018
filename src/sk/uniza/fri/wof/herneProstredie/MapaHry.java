package sk.uniza.fri.wof.herneProstredie;

import com.sun.corba.se.impl.orbutil.RepIdDelegator;
import javax.print.attribute.standard.MediaSize;
import sk.uniza.fri.wof.herneProstredie.dialogy.ReplikaHraca;
import sk.uniza.fri.wof.herneProstredie.dialogy.ReplikaNPC;
import sk.uniza.fri.wof.herneProstredie.npc.INpc;
import sk.uniza.fri.wof.herneProstredie.npc.NpcSRozhovorom;
import sk.uniza.fri.wof.herneProstredie.npc.Osoba;
import sk.uniza.fri.wof.herneProstredie.npc.Vratnik;
import sk.uniza.fri.wof.herneProstredie.predmety.Hodinky;
import sk.uniza.fri.wof.herneProstredie.predmety.Kluc;
import sk.uniza.fri.wof.herneProstredie.predmety.Pacidlo;
import sk.uniza.fri.wof.herneProstredie.predmety.Predmet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class MapaHry {
    
    private Miestnost startovaciaMiestnost;

    public MapaHry() {
        this.startovaciaMiestnost = this.vytvorMiestnosti();
    }

    public Miestnost getStartovaciaMiestnost() {
        return startovaciaMiestnost;
    }
    
    
    
    /**
     * Vytvori mapu hry - miestnosti.
     */
    private Miestnost vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa", "terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula", "aula");
        Miestnost bufet = new Miestnost("bufet", "bufer");
        Miestnost labak = new Miestnost("labak", "pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria", "kancelaria spravcu pocitacoveho laboratoria");
        
        Miestnost chodba1Poschodie = new Miestnost("chodba1Poschodie", "chodba1Poschodie");
        Miestnost chodba2Poschodie = new Miestnost("chodba2Poschodie", "chodba2Poschodie");
        
        Vytah vytah = new Vytah();
        //Vytahove dvere
        VytahoveDvere dvereNaPrizemi = new VytahoveDvere(vytah, aula, 0);
        VytahoveDvere dvereNa1 = new VytahoveDvere(vytah, chodba1Poschodie, 1);
        VytahoveDvere dvereNa2 = new VytahoveDvere(vytah, chodba2Poschodie, 2);
        ObycajneDvere dvereDoBufetu = new ObycajneDvere(aula, bufet);
        
        DvereNaKluc dvereTerasaAula = new DvereNaKluc(aula, terasa);
        
        terasa.pridajPredmet(new Predmet("pero", "modre pero"));
        terasa.pridajPredmet(new Hodinky());
        
        Kluc klucAula = new Kluc("kluc-aula");
        klucAula.pridajDvere(dvereTerasaAula);
        terasa.pridajPredmet(klucAula);
        
        terasa.pridajPredmet(new Pacidlo());
        terasa.pridajPredmet(new PortalGun());
        
        terasa.pridajNpc(new Osoba("Jozko"));
        //terasa.pridajNpc(new Vratnik());
        terasa.pridajNpc(vytvorVratnicku());
        
        
        terasa.pridajNpc(vytvorBufetarku());
        return terasa;  // startovacia miestnost hry
    }
    
    private INpc vytvorVratnicku() {
        ReplikaHraca ukonci = new ReplikaHraca("Koniec rozhovoru", null);
        
        ReplikaNPC uvodnaReplika = new ReplikaNPC("Hmmm");
        ReplikaNPC odpovedNaDobryDen = new ReplikaNPC("Co si zelate?");
        
        
        uvodnaReplika.pridajRepliku(new ReplikaHraca("Dobry den", odpovedNaDobryDen));
        uvodnaReplika.pridajRepliku(ukonci);
        
        odpovedNaDobryDen.pridajRepliku(new ReplikaHraca("Nic, dovi", null));
        odpovedNaDobryDen.pridajRepliku(ukonci);
        
        NpcSRozhovorom vratnicka = new NpcSRozhovorom("vratnicka", uvodnaReplika);
        return vratnicka;
    }

    /*
interakcia bufetarka
Dobry den.
1 Dobry
2 Chcem kupit
3 Dovi

> 2
1 Bageta
2 Kava
3 Pizza

    */
    private INpc vytvorBufetarku() {
        ReplikaNPC uvodnaReplika = new ReplikaNPC("Dobry den");
        ReplikaNPC menu = new ReplikaNPC("Tak si vyber");
        ReplikaNPC kupujBagetu = new ReplikaNPC("Nech sa paci, bageta");
        ReplikaNPC kupujPizzu = new ReplikaNPC("Nech sa paci, pizza");
        ReplikaNPC kupujKavu = new ReplikaNPC("Chcete malu ci velku?");
        ReplikaNPC kupujKavuMalu = new ReplikaNPC("Nech sa paci, mala kava");
        ReplikaNPC kupujKavuVelku = new ReplikaNPC("Nech sa paci, velka kava");
        
        uvodnaReplika.pridajRepliku(new ReplikaHraca("Dobry", null));
        uvodnaReplika.pridajRepliku(new ReplikaHraca("Chcem kupit", menu));
        uvodnaReplika.pridajRepliku(new ReplikaHraca("Dovi", null));
        
        menu.pridajRepliku(new ReplikaHraca("bageta", kupujBagetu));
        menu.pridajRepliku(new ReplikaHraca("kava", kupujKavu));
        menu.pridajRepliku(new ReplikaHraca("pizza", kupujPizzu));
        
        kupujKavu.pridajRepliku(new ReplikaHraca("malu", kupujKavuMalu));
        kupujKavu.pridajRepliku(new ReplikaHraca("velku", kupujKavuVelku));
        
        ReplikaHraca replikaDovi = new ReplikaHraca("Dovi...", null);
        
        kupujBagetu.pridajRepliku(new ReplikaHraca("Dakujem", uvodnaReplika));
        kupujBagetu.pridajRepliku(replikaDovi);
        kupujPizzu.pridajRepliku(new ReplikaHraca("Dakujem", uvodnaReplika));
        kupujPizzu.pridajRepliku(replikaDovi);
        kupujKavuMalu.pridajRepliku(new ReplikaHraca("Dakujem", uvodnaReplika));
        kupujKavuMalu.pridajRepliku(replikaDovi);
        kupujKavuVelku.pridajRepliku(new ReplikaHraca("Dakujem", uvodnaReplika));
        kupujKavuVelku.pridajRepliku(replikaDovi);
        
        NpcSRozhovorom bufetarka = new NpcSRozhovorom("bufetarka", uvodnaReplika);
        return bufetarka;
    }
}

package sk.uniza.fri.wof.herneProstredie;

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
        
        DvereNaKluc dvereTerasaAula = new DvereNaKluc(aula, terasa);
        
        terasa.pridajPredmet(new Predmet("pero", "modre pero"));
        terasa.pridajPredmet(new Hodinky());
        
        Kluc klucAula = new Kluc("kluc-aula");
        klucAula.pridajDvere(dvereTerasaAula);
        terasa.pridajPredmet(klucAula);
        
        terasa.pridajPredmet(new Pacidlo());
        return terasa;  // startovacia miestnost hry
    }
}

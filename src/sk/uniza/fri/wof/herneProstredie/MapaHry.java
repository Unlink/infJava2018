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

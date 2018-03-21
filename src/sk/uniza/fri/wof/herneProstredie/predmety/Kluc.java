/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.predmety;

import java.util.ArrayList;
import sk.uniza.fri.wof.herneProstredie.DvereNaKluc;
import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.IDvere;

/**
 *
 * @author duracik2
 */
public class Kluc implements IPredmet {

    private String nazov;
    private ArrayList<IDvere> dverePreKluc;

    public Kluc(String nazov) {
        this.nazov = nazov;
        this.dverePreKluc = new ArrayList<IDvere>();
    }
    
    public void pridajDvere(IDvere dvere) {
        this.dverePreKluc.add(dvere);
    }
    
    @Override
    public String getNazov() {
        return nazov;
    }

    @Override
    public String getPopis() {
        return "Kluc - "+this.nazov;
    }

    @Override
    public void pouzi(Hrac hrac, String parameter) {
        if (parameter == null) {
            System.out.println("A na ake dvere ho chces pouzit?");
            return;
        }
        
        IDvere dvere = hrac.getAktualnaMiestnost().dajDverePodlaSmeru(parameter);
        if (dvere == null) {
            System.out.println("Taketo dvere v miestnosti niesu");
            return;
        }
        if (!this.dverePreKluc.contains(dvere)) {
            System.out.println("Tento kluc neotvara tieto dvere");
            return;
        }
        
        if (dvere instanceof DvereNaKluc) {
            DvereNaKluc dvereNaKluc = (DvereNaKluc) dvere;
            dvereNaKluc.pouziKluc();
            //@TODO dorobit vypis ci sa dvere odomkli alebo zamkli
            System.out.println("Pouzil si kluc na dvere "+parameter);
        }
    }

    @Override
    public boolean daSaZdvihnut() {
        return true;
    }
    
}

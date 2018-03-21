/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.predmety;

import java.util.ArrayList;
import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.IDvere;
import sk.uniza.fri.wof.herneProstredie.IPoskoditelny;
import sk.uniza.fri.wof.herneProstredie.Miestnost;

/**
 *
 * @author duracik2
 */
public class Pacidlo implements IPredmet {

    @Override
    public String getNazov() {
        return "pacidlo";
    }

    @Override
    public String getPopis() {
        return "pacidlo";
    }

    @Override
    public void pouzi(Hrac hrac) {
        Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        ArrayList<IPredmet> predmety = aktualnaMiestnost.dajPredmety();
        for (IPredmet predmet : predmety) {
            if (predmet instanceof IPoskoditelny) {
                ((IPoskoditelny) predmet).poskod();
            }
        }
        for (IDvere dvere : aktualnaMiestnost.dajDvere()) {
            if (dvere instanceof IPoskoditelny) {
                ((IPoskoditelny) dvere).poskod();
            }
        }
    }
    
}

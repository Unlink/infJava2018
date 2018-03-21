/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.predmety;

import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.Vytah;

/**
 *
 * @author duracik2
 */
public class OvladacVytahu implements IPredmet {

    @Override
    public String getNazov() {
        return "ovladac";
    }

    @Override
    public String getPopis() {
        return "ovladac vytahu";
    }

    @Override
    public void pouzi(Hrac hrac, String parameter) {
        if (hrac.getAktualnaMiestnost() instanceof Vytah) {
            Vytah vytah = (Vytah) hrac.getAktualnaMiestnost();
            vytah.posunSa();
        }
    }

    @Override
    public boolean daSaZdvihnut() {
        return false;
    }
    
}

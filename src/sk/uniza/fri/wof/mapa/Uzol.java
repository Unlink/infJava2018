/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.mapa;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author duracik2
 */
public class Uzol {

    private final String retazec;
    private HashMap<String, Uzol> potomkovia;

    public Uzol(String retazec) {
        this.retazec = retazec;
        this.potomkovia = new HashMap<>();
    }

    public String getRetazec() {
        return retazec;
    }
    
    public void pridajPotomka(Uzol uzol) {
        this.potomkovia.put(uzol.getRetazec(), uzol);
    }

    public ArrayList<Uzol> getPotomkovia() {
        return new ArrayList<>(this.potomkovia.values());
    }
    
}

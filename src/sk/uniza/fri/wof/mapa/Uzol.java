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
    private boolean virtualKey;

    public Uzol(String retazec, boolean virtualKey) {
        this.retazec = retazec;
        this.potomkovia = new HashMap<>();
        this.virtualKey = virtualKey;
    }

    public String getRetazec() {
        return this.retazec;
    }
    
    public boolean isVirtual() {
        return this.virtualKey;
    }
    
    public String getKluc() {
        if (this.retazec == null) {
            return null;
        }
        return this.retazec.split(":")[0].trim();
    }
    
    public void pridajPotomka(Uzol uzol) {
        this.potomkovia.put(uzol.getKluc(), uzol);
    }
    
    public Uzol najdiPotomka(String kluc) {
        return this.potomkovia.get(kluc);
    }

    public ArrayList<Uzol> getPotomkovia() {
        return new ArrayList<>(this.potomkovia.values());
    }

    public String getHodnota() {
        if (this.retazec == null) {
            return null;
        }
        return this.retazec.split(":")[1].trim();
    }
    
}

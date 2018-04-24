/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.mapa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.uniza.fri.wof.herneProstredie.Miestnost;

/**
 *
 * @author duracik2
 */
public class NacitavacMapy {
    
    private HashMap<String, Miestnost> miestnosti;

    public NacitavacMapy() {
        this.miestnosti = new HashMap<>();
    }
    
    public Miestnost nacitajMapu(String cestaKSuboru) {
        SpracovavacSuboru fileReader = new SpracovavacSuboru();
        try {
            Uzol koren = fileReader.nahrajSubor(cestaKSuboru);
            this.nacitajMiestnosti(koren.najdiPotomka("miestnosti"));
            return this.miestnosti.get(koren.najdiPotomka("start").getHodnota());
        } catch (IOException ex) {
            
        }
        return null;
    }

    private void nacitajMiestnosti(Uzol miestnosti) {
        for (Uzol potomok : miestnosti.getPotomkovia()) {
            Miestnost m = new Miestnost(potomok.getKluc(), potomok.getHodnota());
            this.miestnosti.put(m.getNazov(), m);
        }
    }
    
}

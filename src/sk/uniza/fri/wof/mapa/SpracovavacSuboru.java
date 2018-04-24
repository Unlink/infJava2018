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

/**
 *
 * @author Unlink
 */
public class SpracovavacSuboru {
    
     public Uzol nahrajSubor(String cestaKSuboru) throws IOException {
        Uzol koren = new Uzol(null);
        ArrayList<Uzol> zasobnik = new ArrayList<>();
        zasobnik.add(koren);
        
        try (BufferedReader reader = new BufferedReader(new FileReader(cestaKSuboru))) {
            String riadok;
            while ((riadok = reader.readLine())!=null) {
                riadok = this.odstranKomentare(riadok);
                if (riadok.isEmpty()) {
                    continue;
                }
                
                int odsadenie = this.getOdsadenie(riadok);
                Uzol potomok = new Uzol(riadok.trim());
                if (zasobnik.size() <= odsadenie+1) {
                    zasobnik.add(potomok);
                }
                else {
                    zasobnik.set(odsadenie+1, potomok);
                }
                zasobnik.get(odsadenie).pridajPotomka(potomok);
            }
        }
        return koren;
    }

    private String odstranKomentare(String riadok) {
        int poziciaKomentara = riadok.indexOf("#");
        if (poziciaKomentara >= 0) {
            riadok = riadok.substring(0, poziciaKomentara);
        }
        riadok = this.rtrim(riadok);
        return riadok;
    }
    
    //Zdroj: https://stackoverflow.com/questions/15567010/what-is-a-good-alternative-of-ltrim-and-rtrim-in-java
    public String rtrim(String s) {
        int i = s.length()-1;
        while (i >= 0 && Character.isWhitespace(s.charAt(i))) {
            i--;
        }
        return s.substring(0,i+1);
    }

    private int getOdsadenie(String riadok) {
        return riadok.lastIndexOf("\t")+1;
    }
    
}

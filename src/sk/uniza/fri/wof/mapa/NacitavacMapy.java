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
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.uniza.fri.wof.herneProstredie.Miestnost;

/**
 *
 * @author duracik2
 */
public class NacitavacMapy {

    public NacitavacMapy() {
    }
    
    public Miestnost nacitajMapu(String cestaKSuboru) {
        SpracovavacSuboru fileReader = new SpracovavacSuboru();
        try {
            Uzol koren = fileReader.nahrajSubor(cestaKSuboru);
            System.out.println("Nacitane");
        } catch (IOException ex) {
            
        }
        return null;
    }
    
}

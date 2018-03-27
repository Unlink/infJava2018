/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.dialogy;

import java.util.ArrayList;

/**
 *
 * @author duracik2
 */
public class ReplikaNPC {

    private final String sprava;
    private ArrayList<ReplikaHraca> replikyHraca;

    public ReplikaNPC(String sprava) {
        this.sprava = sprava;
        this.replikyHraca = new ArrayList<>();
    }
    
    public void pridajRepliku(ReplikaHraca replikaHraca) {
        this.replikyHraca.add(replikaHraca);
    }
    
    public String dajSpravu() {
        return this.sprava;
    }
    
    public void vypisMoznosti() {
        int pocitadlo = 0;
        for (ReplikaHraca replikaHraca : this.replikyHraca) {
            System.out.println("\t " + pocitadlo + ": " + replikaHraca.dajSpravu());
            pocitadlo++;
        }
    }
    
    public ReplikaHraca vyberReplikuHraca(int cisloRepliky) {
        if (cisloRepliky >= this.replikyHraca.size() || cisloRepliky < 0) {
            return null;
        }
        return this.replikyHraca.get(cisloRepliky);
    }
}

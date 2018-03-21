/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.npc;

import sk.uniza.fri.wof.herneProstredie.Hrac;

/**
 *
 * @author duracik2
 */
public class Osoba implements INpc {

    private final String meno;

    public Osoba(String meno) {
        this.meno = meno;
    }
    
    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void interakcia(Hrac hrac, String typ) {
        System.out.println("Osoba "+this.meno+" hovori: Ahoj");
    }
    
}

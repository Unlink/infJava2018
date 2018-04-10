/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.questy;

import sk.uniza.fri.wof.herneProstredie.Hrac;

/**
 *
 * @author duracik2
 */
public class NajdiSekeru extends Quest {

    public NajdiSekeru() {
        super("V tomto paradnom qeste mas za ulohu najst sekeru");
    }

    @Override
    public void skontrolujCiSplneny(Hrac hrac) {
        if (hrac.maPredmet("sekera")) {
            System.out.println("Super, splnil si quest lebo si nasiel sekeru");
            this.oznacAkoSplneny();
        }
    }
    
}

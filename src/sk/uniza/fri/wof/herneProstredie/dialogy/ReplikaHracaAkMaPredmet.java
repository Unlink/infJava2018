/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.dialogy;

import sk.uniza.fri.wof.herneProstredie.Hrac;


public class ReplikaHracaAkMaPredmet extends ReplikaHraca {

    private String pozadovanyPredmet;
    
    public ReplikaHracaAkMaPredmet(String sprava, ReplikaNPC replikaNPC, String pozadovanyPredmet) {
        super(sprava, replikaNPC);
        this.pozadovanyPredmet = pozadovanyPredmet;
    }

    @Override
    public boolean jeSkryta(Hrac hrac) {
        return !hrac.maPredmet(this.pozadovanyPredmet);
    }
    
    
}

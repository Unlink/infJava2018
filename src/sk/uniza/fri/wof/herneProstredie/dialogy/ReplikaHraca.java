/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.dialogy;

import sk.uniza.fri.wof.herneProstredie.Hrac;


/**
 *
 * @author duracik2
 */
public class ReplikaHraca {

    private final String sprava;
    private final ReplikaNPC replikaNPC;

    /**
     *
     * @param sprava
     * @param replikaNPC
     */
    public ReplikaHraca(String sprava, ReplikaNPC replikaNPC) {
        this.sprava = sprava;
        this.replikaNPC = replikaNPC;
    }
    
    public String dajSpravu() {
        return this.sprava;
    }
    
    public ReplikaNPC dalsiaReplikaNPC() {
        return this.replikaNPC;
    }
    
    /**
     * @param hrac
     * @return true ak ukoncuje rozhovor
     */
    public boolean vykonaj(Hrac hrac) {
        return false;
    }
}

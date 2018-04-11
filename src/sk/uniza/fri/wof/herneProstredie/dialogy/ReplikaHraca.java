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
    private final boolean jednorazova;

    /**
     *
     * @param sprava
     * @param replikaNPC
     */
    public ReplikaHraca(String sprava, ReplikaNPC replikaNPC) {
        this(sprava, replikaNPC, false);
    }

    public ReplikaHraca(String sprava, ReplikaNPC replikaNPC, boolean jednorazova) {
        this.sprava = sprava;
        this.replikaNPC = replikaNPC;
        this.jednorazova = jednorazova;
    }
    
    
    
    public String dajSpravu() {
        return this.sprava;
    }
    
    public ReplikaNPC dalsiaReplikaNPC() {
        return this.replikaNPC;
    }
    
    public void vykonaj(Hrac hrac) {
    }

    public boolean jeJednorazova() {
        return jednorazova;
    }
    
    public boolean jeSkryta(Hrac hrac) {
        return false;
    }
}

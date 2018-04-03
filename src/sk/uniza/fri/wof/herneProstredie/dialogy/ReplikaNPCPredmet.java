/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.dialogy;

import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;

/**
 *
 * @author duracik2
 */
public class ReplikaNPCPredmet extends ReplikaNPC {

    private IPredmet predmet;
    
    public ReplikaNPCPredmet(String sprava, IPredmet predmet) {
        super(sprava);
        this.predmet = predmet;
    }

    @Override
    public void vykonajAkciu(Hrac hrac) {
        hrac.pridajPredmet(predmet);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.dialogy;

import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.questy.Quest;

/**
 *
 * @author duracik2
 */
public class ReplikaNPCPridajQuest extends ReplikaNPC {
    
    private Quest quest;

    public ReplikaNPCPridajQuest(String popis, Quest quest) {
        super(popis);
        this.quest = quest;
    }

    @Override
    public void vykonajAkciu(Hrac hrac) {
        super.vykonajAkciu(hrac);
        hrac.pridajQuest(quest);
    }
    
    
    
}

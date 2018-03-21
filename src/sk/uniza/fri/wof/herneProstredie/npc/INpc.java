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
public interface INpc {
    String getMeno();
    void interakcia(Hrac hrac, String typ);
}

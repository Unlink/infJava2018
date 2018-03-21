/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.npc;

import java.util.ArrayList;
import java.util.Stack;
import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;
import sk.uniza.fri.wof.herneProstredie.predmety.Predmet;

/**
 *
 * @author duracik2
 */
public class Vratnik implements INpc {

    private Stack<IPredmet> inventar;

    public Vratnik() {
        inventar = new Stack<>();
        inventar.push(new Predmet("zuvacka", "zuvacka"));
        inventar.push(new Predmet("fixka", "fixka cervena"));
    }
    
    @Override
    public String getMeno() {
        return "vratnik";
    }

    @Override
    public void interakcia(Hrac hrac, String typ) {
        if (inventar.size() > 0) {
            IPredmet predmet = inventar.pop();
            System.out.println("Nech sa paci "+predmet.getNazov());
            hrac.pridajPredmet(predmet);
        }
        else {
            System.out.println("Uz nic nemam");
        }
    }
    
}

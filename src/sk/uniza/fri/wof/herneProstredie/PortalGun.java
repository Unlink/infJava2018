/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie;

import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;

/**
 *
 * @author Unlink
 */
public class PortalGun implements IPredmet {
    
    private PortaloveDvere portaloveDvere;
    private boolean jePoslednyModry;

    public PortalGun() {
        this.jePoslednyModry = false;
        this.portaloveDvere = new PortaloveDvere();
    }
    

    @Override
    public String getNazov() {
        return "portalGun";
    }

    @Override
    public String getPopis() {
        return "portal gun ako z hry portal od valve";
    }

    @Override
    public void pouzi(Hrac hrac, String parameter) {
        if (this.jePoslednyModry) {
            portaloveDvere.pridajOranzovyPortal(hrac.getAktualnaMiestnost());
            System.out.println("Vytvoril si oranzovy portal");
        } 
        else {
            portaloveDvere.pridajModryPortal(hrac.getAktualnaMiestnost());
            System.out.println("Vytvoril si modry portal");
        }
        this.jePoslednyModry = !this.jePoslednyModry;
    }

    @Override
    public boolean daSaZdvihnut() {
        return true;
    }
    
}

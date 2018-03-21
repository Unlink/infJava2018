/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie;

/**
 *
 * @author Unlink
 */
public class PortaloveDvere implements IDvere {

    private Miestnost modryPortal;
    private Miestnost oranzovyPortal;

    public PortaloveDvere() {
        this.modryPortal = null;
        this.oranzovyPortal = null;
    }
    
    @Override
    public boolean suPrechodne(Miestnost miestnost) {
        return this.modryPortal != null && this.oranzovyPortal != null;
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost miestnost) {
        return miestnost == this.modryPortal ? this.oranzovyPortal : this.modryPortal;
    }
    
    public void pridajModryPortal(Miestnost miestnost) {
        if (this.modryPortal != null) {
            this.modryPortal.odstranDvere("modry-portal");
        }
        this.modryPortal = miestnost;
        this.modryPortal.nastavDvere("modry-portal", this);
    }
    
    public void pridajOranzovyPortal(Miestnost miestnost) {
        if (this.oranzovyPortal != null) {
            this.oranzovyPortal.odstranDvere("oranzovy-portal");
        }
        this.oranzovyPortal = miestnost;
        this.oranzovyPortal.nastavDvere("oranzovy-portal", this);
    }
    
}

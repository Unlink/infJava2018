/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie;

/**
 *
 * @author duracik2
 */
public class VytahoveDvere extends ObycajneDvere {
    
    private boolean otvorene;
    private final int poschodie;
    
    public VytahoveDvere(Vytah vytah, Miestnost druha, int poschodie) {
        super(vytah, druha);
        this.otvorene = false;
        this.poschodie = poschodie;
    }

    public void setOtvorene(boolean otvorene) {
        this.otvorene = otvorene;
    }

    @Override
    public boolean suPrechodne(Miestnost miestnost) {
        return this.otvorene;
    }

    public int getPoschodie() {
        return poschodie;
    }
    
    
    
}

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
public class ObycajneDvere implements IDvere {

    private final Miestnost prvaMisetnost;
    private final Miestnost druhaMiestnost;

    public ObycajneDvere(Miestnost prva, Miestnost druha) {
        this.prvaMisetnost = prva;
        this.druhaMiestnost = druha;
        
        this.prvaMisetnost.nastavDvere(druha.getNazov(), this);
        this.druhaMiestnost.nastavDvere(prva.getNazov(), this);
    }
    
    @Override
    public boolean suPrechodne(Miestnost miestnost) {
        return true;
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost miestnost) {
        return this.prvaMisetnost == miestnost ? this.druhaMiestnost : this.prvaMisetnost;
    }
    
}

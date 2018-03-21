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
public class DvereNaKluc implements IDvere, IPoskoditelny {

    private boolean zamknute;
    private final Miestnost prvaMisetnost;
    private final Miestnost druhaMiestnost;

    public DvereNaKluc(Miestnost prvaMisetnost, Miestnost druhaMiestnost) {
        this.prvaMisetnost = prvaMisetnost;
        this.druhaMiestnost = druhaMiestnost;
        this.zamknute = true;
        
        this.prvaMisetnost.nastavDvere(druhaMiestnost.getNazov(), this);
        this.druhaMiestnost.nastavDvere(prvaMisetnost.getNazov(), this);
    }
    
    @Override
    public boolean suPrechodne(Miestnost miestnost) {
        return !this.zamknute;
    }

    @Override
    public Miestnost dajDruhuMiestnost(Miestnost miestnost) {
        return miestnost == this.prvaMisetnost ? this.druhaMiestnost : this.prvaMisetnost;
    }

    public void pouziKluc() {
        if (this.zamknute) {
            System.out.println("Odomkol si dvere");
        }
        else {
            System.out.println("Zamkol si dvere");
        }
        this.zamknute = !this.zamknute;
    }

    @Override
    public void poskod() {
        //Rozbije a odomkne dvere
        this.zamknute = false;
    }
    
}

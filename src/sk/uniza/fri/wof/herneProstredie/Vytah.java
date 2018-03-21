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
public class Vytah extends Miestnost {
    
    private int aktualnePoschodie;
    private boolean ideHore;
    
    public Vytah() {
        super("vytah", "vytah na fri");
        this.aktualnePoschodie = 0;
        this.ideHore = true; 
    }

    public void posunSa() {
        //Zatvorit dvere
        VytahoveDvere dvere = dajAktualneDvere();
        if (dvere != null) {
            dvere.setOtvorene(false);
        }
        
        //Posunut sa
        this.aktualnePoschodie += this.ideHore ? 1 : -1;
        
        if (this.aktualnePoschodie == -1) {
            //Ak chcem sa dostanem na -1 tak musim zmenit smer a z 0 pojdem na 1
            this.aktualnePoschodie = 1;
            this.ideHore = true;
        }
        else if (this.aktualnePoschodie == this.dajDvere().size()) {
            //Ak som presiel uplne hore tak sa o 2 vrati spat a vytah pojde dole
            this.aktualnePoschodie -= 2;
            this.ideHore = false;
        }
        
        //Otvorit dvere
        dvere = dajAktualneDvere();
        if (dvere != null) {
            dvere.setOtvorene(true);
        }
        
        this.vypisInfoOMiestnosti();
    }
    
    private VytahoveDvere dajAktualneDvere() {
        for (IDvere dvere : dajDvere()) {
            if (((VytahoveDvere)dvere).getPoschodie() == aktualnePoschodie) {
                return (VytahoveDvere) dvere;
            }
        }
        return null;
    }
}

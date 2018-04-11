/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.questy;

import sk.uniza.fri.wof.herneProstredie.Hrac;

/**
 *
 * @author duracik2
 */
public abstract class Quest {
    
    private String popis;
    private StavQuestu stav;

    public Quest(String popis) {
        this.popis = popis;
        this.stav = StavQuestu.NOVY;
    }
    
    public void akceptuj(Hrac hrac) {
        this.stav = StavQuestu.AKTIVNY;
    }
    
    public abstract void skontrolujCiSplneny(Hrac hrac);

    protected void oznacAkoSplneny() {
        if (this.stav == StavQuestu.AKTIVNY) {
            this.stav = StavQuestu.SPLNENY;
        }
    }
    
    protected void oznacAkoNesplneny() {
        if (this.stav == StavQuestu.AKTIVNY) {
            this.stav = StavQuestu.NESPLNENY;
        }
    }

    public String getPopis() {
        return this.popis;
    }

     public boolean jeAktivny() {
        return this.stav == StavQuestu.AKTIVNY;
    }
    
}

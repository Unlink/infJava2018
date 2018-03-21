package sk.uniza.fri.wof.herneProstredie.predmety;


import sk.uniza.fri.wof.herneProstredie.Hrac;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public interface IPredmet {

    String getNazov();

    String getPopis();

    void pouzi(Hrac hrac, String parameter);
    
    boolean daSaZdvihnut();
}

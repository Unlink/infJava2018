package sk.uniza.fri.wof.herneProstredie.predmety;


import sk.uniza.fri.wof.herneProstredie.Hrac;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author duracik2
 */
public class Predmet implements IPredmet {
    private String nazov;
    private String popis;

    public Predmet(String nazov, String popis) {
        this.nazov = nazov;
        this.popis = popis;
    }

    @Override
    public String getNazov() {
        return nazov;
    }

    @Override
    public String getPopis() {
        return popis;
    }

    @Override
    public void pouzi(Hrac hrac, String parameter) {
        System.out.println("Neviem ako");
    }
}

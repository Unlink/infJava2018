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
public class Hodinky implements IPredmet {

    @Override
    public String getNazov() {
        return "hodinky";
    }

    @Override
    public String getPopis() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    @Override
    public void pouzi(Hrac hrac) {
        System.out.println(getPopis());
    }
    
}

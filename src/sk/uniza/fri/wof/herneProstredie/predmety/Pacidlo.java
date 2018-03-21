/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.predmety;

import java.util.ArrayList;
import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.IDvere;
import sk.uniza.fri.wof.herneProstredie.IPoskoditelny;
import sk.uniza.fri.wof.herneProstredie.Miestnost;

/**
 *
 * @author duracik2
 */
public class Pacidlo implements IPredmet {

    @Override
    public String getNazov() {
        return "pacidlo";
    }

    @Override
    public String getPopis() {
        return "pacidlo";
    }

    @Override
    public void pouzi(Hrac hrac, String parameter) {
        if (parameter == null) {
            System.out.println("A a čo chceš pouzit toto pacidlo?");
            return;
        }
        
        Miestnost aktualnaMiestnost = hrac.getAktualnaMiestnost();
        IPredmet predmet = aktualnaMiestnost.dajPredmety(parameter);
        IDvere dvere = aktualnaMiestnost.dajDverePodlaSmeru(parameter.replace("dvere-", ""));
        if (predmet != null) {
            if (predmet instanceof IPoskoditelny) {
                ((IPoskoditelny) predmet).poskod();
                System.out.println("Poskodil si predet "+predmet.getNazov());
            }
            else {
                System.out.println("Tento predmet sa neda poskodit");
            }
        }
        else if (dvere != null) {
            if (dvere instanceof IPoskoditelny) {
                ((IPoskoditelny) dvere).poskod();
                System.out.println("Poskodil si dvere");
            }
            else {
                System.out.println("Tento dvere sa nedaju poskodit");
            }
        }
        else {
            System.out.println("Nepoznam takýto objekt");
        }
        
    }
    
}

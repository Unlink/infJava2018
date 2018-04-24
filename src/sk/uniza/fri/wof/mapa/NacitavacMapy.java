/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.mapa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.logging.Level;
import java.util.logging.Logger;
import sk.uniza.fri.wof.herneProstredie.DvereNaKluc;
import sk.uniza.fri.wof.herneProstredie.IDvere;
import sk.uniza.fri.wof.herneProstredie.Miestnost;
import sk.uniza.fri.wof.herneProstredie.ObycajneDvere;
import sk.uniza.fri.wof.herneProstredie.PortalGun;
import sk.uniza.fri.wof.herneProstredie.Vytah;
import sk.uniza.fri.wof.herneProstredie.VytahoveDvere;
import sk.uniza.fri.wof.herneProstredie.predmety.Hodinky;
import sk.uniza.fri.wof.herneProstredie.predmety.IPredmet;
import sk.uniza.fri.wof.herneProstredie.predmety.Kluc;
import sk.uniza.fri.wof.herneProstredie.predmety.Pacidlo;
import sk.uniza.fri.wof.herneProstredie.predmety.Predmet;

/**
 *
 * @author duracik2
 */
public class NacitavacMapy {
    
    private HashMap<String, Miestnost> miestnosti;
    private HashMap<String, IPredmet> predmety;

    public NacitavacMapy() {
        this.miestnosti = new HashMap<>();
        this.predmety = new HashMap<>();
    }
    
    public Miestnost nacitajMapu(String cestaKSuboru) {
        SpracovavacSuboru fileReader = new SpracovavacSuboru();
        try {
            Uzol koren = fileReader.nahrajSubor(cestaKSuboru);
            this.nacitajMiestnosti(koren.najdiPotomka("miestnosti"));
            this.nacitajDvere(koren.najdiPotomka("dvere"));
            return this.miestnosti.get(koren.najdiPotomka("start").getHodnota());
        } catch (IOException ex) {
            
        }
        return null;
    }

    private void nacitajMiestnosti(Uzol miestnosti) {
        for (Uzol potomok : miestnosti.getPotomkovia()) {
            Miestnost m = this.vyrvorMiestnost(potomok.getKluc(), potomok.getHodnota());
            this.miestnosti.put(m.getNazov(), m);
            
            if (potomok.najdiPotomka("predmety") != null) {
                this.nacitajPredmety(m, potomok.najdiPotomka("predmety"));
            }
        }
    }
    
     public Miestnost vyrvorMiestnost(String key, String popis) {
        switch (key) {
            case "vytah":
                return new Vytah();
            default:
                return new Miestnost(key, popis);
        }
     }

    private void nacitajPredmety(Miestnost miestnost, Uzol predmety) {
        for (Uzol predmet : predmety.getPotomkovia()) {
            //Vytvarame obycajny predmet
            IPredmet p;
            if (!predmet.isVirtual()) {
                p = new Predmet(predmet.getKluc(), predmet.getHodnota());
            }
            else {
                Scanner scanner = new Scanner(predmet.getHodnota());
                String name = scanner.next();
                ArrayList<String> parametre = new ArrayList<>();
                while (scanner.hasNext()) {
                    parametre.add(scanner.next());
                }
                p = vyrvorPredmet(name, parametre);
            }
            this.predmety.put(p.getNazov(), p);
            miestnost.pridajPredmet(p);
        }
    }
    
    public IPredmet vyrvorPredmet(String className, ArrayList<String> parametre) {
        switch (className) {
            case "Hodinky":
                return new Hodinky();
            case "Kluc":
                return new Kluc(parametre.get(0)); 
            case "PortalGun":
                return new PortalGun();
             case "Pacidlo":
                return new Pacidlo();
            default:
                return null;
        }
    }

    private void nacitajDvere(Uzol dvere) {
        for (Uzol info : dvere.getPotomkovia()) {
            //Obycajne dvere
            if (info.isVirtual()) {
                String[] nazovMiestnosti = info.getHodnota().split(" ");
                IDvere d = new ObycajneDvere(this.miestnosti.get(nazovMiestnosti[0]), this.miestnosti.get(nazovMiestnosti[1]));
            }
            else {
                Scanner scanner = new Scanner(info.getHodnota());
                ArrayList<String> parametre = new ArrayList<>();
                while (scanner.hasNext()) {
                    parametre.add(scanner.next());
                }
                vyrvorDvere(info.getKluc(), parametre);
            }
        }
    }

    private IDvere vyrvorDvere(String className, ArrayList<String> parametre) {
        switch (className) {
            case "DvereNaKluc":
                DvereNaKluc dvere = new DvereNaKluc(this.miestnosti.get(parametre.get(0)), this.miestnosti.get(parametre.get(1)));
                for (int i = 2; i < parametre.size(); i++) {
                    Kluc kluc = (Kluc) this.predmety.get(parametre.get(i));
                    kluc.pridajDvere(dvere);
                }
                return dvere;
            case "VytahoveDvere":
                Miestnost m1 = this.miestnosti.get(parametre.get(0));
                Miestnost m2 = this.miestnosti.get(parametre.get(1));
                int poschodie = Integer.parseInt(parametre.get(2));
                return new VytahoveDvere((Vytah) m2, m1, poschodie);
            default:
                return null;
        }
    }
    
}

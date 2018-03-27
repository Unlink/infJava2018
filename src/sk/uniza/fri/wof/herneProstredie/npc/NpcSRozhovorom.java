/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sk.uniza.fri.wof.herneProstredie.npc;

import java.util.Scanner;
import sk.uniza.fri.wof.herneProstredie.Hrac;
import sk.uniza.fri.wof.herneProstredie.dialogy.ReplikaHraca;
import sk.uniza.fri.wof.herneProstredie.dialogy.ReplikaNPC;

/**
 *
 * @author duracik2
 */
public class NpcSRozhovorom implements INpc {

    private final String meno;
    private final ReplikaNPC uvodnaReplika;
    
    public NpcSRozhovorom(String meno, ReplikaNPC uvodnaReplika) {
        this.meno = meno;
        this.uvodnaReplika = uvodnaReplika;
    }
    
    @Override
    public String getMeno() {
        return this.meno;
    }

    @Override
    public void interakcia(Hrac hrac, String typ) {
        
        ReplikaNPC aktualnaReplika = this.uvodnaReplika;
        Scanner scanner = new Scanner(System.in);
        
        while (aktualnaReplika != null) {
            //Vypis repliku npc
            System.out.println(aktualnaReplika.dajSpravu());
            aktualnaReplika.vypisMoznosti();
            ReplikaHraca replikaHraca;
            
            do {
                System.out.print("> ");
                String riadok = scanner.nextLine();
                int volba = Integer.parseInt(riadok);
                replikaHraca = aktualnaReplika.vyberReplikuHraca(volba);
                if (replikaHraca == null) {
                    System.out.println("Zla volba, zadaj znovu");
                }
            } while (replikaHraca == null);
            
            //Ak koniec rozhovoru
            if (replikaHraca.vykonaj(hrac)) {
                aktualnaReplika = null;
            }
            else {
                aktualnaReplika = replikaHraca.dalsiaReplikaNPC();
            }
        }
        
        
        //Overit a ked neplatna tak znovu
        //Zmen repliku a opakuj
        
    }
    
}

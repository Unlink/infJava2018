package sk.uniza.fri.wof.hra;

import java.io.File;
import java.io.FileNotFoundException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;

/**
 * Trieda Parser cita vstup zadany hracom do terminaloveho okna a pokusi sa
 * interpretovat ho ako prikaz hry. Kazda sprava dajPrikaz sposobi, ze parser
 * precita jeden riadok z terminaloveho okna a vyberie z neho prve dve slova.
 * Tie dve slova pouzije ako parametre v sprave new triede Prikaz.
 * 
 * @author  Michael Kolling and David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
public class Parser {
    private NazvyPrikazov prikazy;  // odkaz na pripustne nazvy prikazov
    private Scanner citac;         // zdroj vstupov od hraca
    private ArrayList<String> historia;
    private ArrayList<String> buffer;

    /**
     * Vytvori citac na citanie vstupov z terminaloveho okna.
     */
    public Parser() {
        this.prikazy = new NazvyPrikazov();
        this.citac = new Scanner(System.in);
        this.historia = new ArrayList<String>();
        this.buffer = new ArrayList<>();
    }

    /**
     * @return prikaz zadany hracom
     */
    public Prikaz nacitajPrikaz() {
        System.out.print("> ");     // vyzva pre hraca na zadanie prikazu

        String vstupnyRiadok = null;
        
        if (this.buffer.size() > 0) {
            String line = this.buffer.remove(0);
            System.out.println(line);
            vstupnyRiadok = line;
        }
        else {
            vstupnyRiadok = this.citac.nextLine();
        }
        this.historia.add(vstupnyRiadok);

        String prikaz = null;
        String[] parametere = new String[0];

        // najde prve dve slova v riadku 
        Scanner tokenizer = new Scanner(vstupnyRiadok);
        if (tokenizer.hasNext()) {
            prikaz = tokenizer.next();      // prve slovo
            if (tokenizer.hasNextLine()) {
                String parametersString = tokenizer.nextLine().trim();
                parametere = parametersString.split(" ");
            }
        }

        // kontrola platnosti prikazu
        if (this.prikazy.jePrikaz(prikaz)) {
            // vytvori platny prikaz
            return new Prikaz(prikaz, parametere);
        } else {
            // vytvori neplatny - "neznamy" prikaz
            return new Prikaz(null, parametere); 
        }
    }

    public void ulozMakro(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            System.out.println("Kolko?");
            return;
        }
        
        int pocet = 0;
        try {
            pocet = Integer.parseInt(prikaz.getParameter());
        } catch (NumberFormatException ex) {
            System.out.println("Nespravny parameter");
            return;
        }
        
        try (PrintWriter zapisovac = new PrintWriter(prikaz.getParameter(1))) {
            for (int i = Math.max(0, this.historia.size() - pocet - 2); i < this.historia.size()-1; i++) {
                zapisovac.println(this.historia.get(i));
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Nepodarilo sa zapisat data");
            return;
        }
    }

    public void nacitajMakro(Prikaz prikaz) {
        try (Scanner citac = new Scanner(new File(prikaz.getParameter()))){
            while (citac.hasNextLine()) {  
                String line = citac.nextLine();
                this.buffer.add(line);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Not found");
        }
    }
}

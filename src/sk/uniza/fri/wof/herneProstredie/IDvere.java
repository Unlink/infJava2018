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
public interface IDvere {
    boolean suPrechodne(Miestnost miestnost);
    Miestnost dajDruhuMiestnost(Miestnost miestnost);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.Potato;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class PotatoWedges implements Potato{
    @Override
    public String getPotato() {
        return "감자튀김 : 웨지 감자";
    }
    public PotatoWedges() {
        //System.out.println("Potato Wedges");
    }
}

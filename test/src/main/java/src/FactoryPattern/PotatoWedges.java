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
    
    String indname;
    
    public PotatoWedges() {
        indname = "웨지 감자";
    }
    
    @Override
    public String getPotato() {
        return indname;
    }
}

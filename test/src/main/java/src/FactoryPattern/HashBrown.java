/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class HashBrown implements Potato{
    String indname;
    
    public HashBrown() {
        indname = "해시 브라운";
    }
    
    @Override
    public String getPotato() {
        return indname;
    }
}

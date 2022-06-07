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
public class BlackBun implements Bun{
    
    String indname;
    
    public BlackBun() {
        indname = "블랙 번";
    }
    
    @Override
    public String getBun() {
        return indname; 
    }
}

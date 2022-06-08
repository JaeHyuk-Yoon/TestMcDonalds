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
public class CheddarCheese implements Cheese{
    
    String indname;
    
    public CheddarCheese() {
        //System.out.println("Cheddar Cheese");
        indname = "체다 치즈";
    }
    
    @Override
    public String getCheese() {
        return indname;
    }
}

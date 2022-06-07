/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.Cheese;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class MozzarellaCheese implements Cheese{
    String indname;
    
    public MozzarellaCheese() {
        indname = "모짜렐라 치즈";
        //System.out.println("Mozzarella Cheese");
    }
    
    @Override
    public String getCheese() {
        return indname;
    }
}

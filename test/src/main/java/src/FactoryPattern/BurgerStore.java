/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import java.util.ArrayList;
import src.StrategyPattern.Burger;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public abstract class BurgerStore{
    
    //public abstract Burger createBurger(Burger item);
    public abstract ArrayList<String> getTotalStoreInd();
    public abstract BurgerStoreIngredientFactory getFactory();
        
//    public Burger orderBurger(Burger type) {
//        Burger burger = null;
//
//        burger = createBurger(type);
//
//        return burger;
//    
//    }    
}

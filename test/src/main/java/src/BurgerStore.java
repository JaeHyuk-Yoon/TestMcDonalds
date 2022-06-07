/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public abstract class BurgerStore{
    
    public abstract Burger createBurger(String item);
        
    public Burger orderBurger(String type) {
        Burger burger = null;

        burger = createBurger(type);

        return burger;
    
    }    
}

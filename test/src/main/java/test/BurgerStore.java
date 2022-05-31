/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public abstract class BurgerStore extends Menu{
    public abstract Menu createBurger(String item);
    
    public Menu orderBurger(String type) {
    Menu burger = null;

    burger = createBurger(type);

    burger.getDescription();
    burger.cost();

    return burger;
    
    }    
}

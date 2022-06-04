/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author JaeHyuk
 */
public class ToppingCheese extends BurgerToppingdecorator {
    Burger burger;
    public ToppingCheese(Burger burger) { this.burger = burger;}
    public String getDescription() {
        return burger.getDescription() + ", add ToppingCheese";
    }
    public int cost() { return 500 + burger.cost();}
    
}

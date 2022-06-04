/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author JaeHyuk
 */
public class ToppingLettuce extends BurgerToppingdecorator {
    Burger burger;
    public ToppingLettuce(Burger burger) { this.burger = burger;}
    public String getDescription() {
        return burger.getDescription() + ", add ToppingLettuce";
    }
    public int cost() { return 500 + burger.cost();}
}

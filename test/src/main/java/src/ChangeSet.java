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
public class ChangeSet extends BurgerToppingdecorator {
    Burger burger;
    public ChangeSet(Burger burger) { this.burger = burger;}
    public String getDescription() {
        return burger.getDescription() + ", Change Set";
    }
    public int cost() { return 1500 + burger.cost();}
}

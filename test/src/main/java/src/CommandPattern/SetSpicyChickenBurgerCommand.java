/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.Burger;
import src.StrategyPattern.SpicyChickenBurger;

/**
 *
 * @author JaeHyuk
 */
public class SetSpicyChickenBurgerCommand implements Command {
    
    private BurgerReceiver burgerReceiver;
    Burger burger;
    BurgerStore burgerStore;
    
    public SetSpicyChickenBurgerCommand(BurgerReceiver burgerReceiver, BurgerStore BurgerStore) {
        this.burgerReceiver = burgerReceiver;
        this.burgerStore = BurgerStore;
    }
    public void execute() {
        burger = new SpicyChickenBurger(burgerStore.getFactory());
        burgerReceiver.addBurger(burger, burgerStore);
    }
}

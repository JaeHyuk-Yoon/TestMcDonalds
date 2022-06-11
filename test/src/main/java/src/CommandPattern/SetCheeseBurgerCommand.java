/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.Burger;
import src.StrategyPattern.CheeseBurger;

/**
 *
 * @author JaeHyuk
 */
public class SetCheeseBurgerCommand implements Command {
    
    private BurgerReceiver burgerReceiver;
    Burger burger;
    BurgerStore burgerStore;
    
    public SetCheeseBurgerCommand(BurgerReceiver burgerReceiver, BurgerStore BurgerStore) {
        this.burgerReceiver = burgerReceiver;
        this.burgerStore = BurgerStore;
    }
    public void execute() {
        burger = new CheeseBurger(burgerStore.getFactory());
        burgerReceiver.addBurger(burger, burgerStore);
    }
    
}

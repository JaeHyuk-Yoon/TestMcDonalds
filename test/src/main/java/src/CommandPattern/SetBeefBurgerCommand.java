/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.Menu;
import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.BeefBurger;
import src.StrategyPattern.Burger;

/**
 *
 * @author JaeHyuk
 */
public class SetBeefBurgerCommand implements Command {
    
    private BurgerReceiver burgerReceiver;
    Burger burger;
    BurgerStore burgerStore;
    
    public SetBeefBurgerCommand(BurgerReceiver burgerReceiver, BurgerStore BurgerStore) {
        this.burgerReceiver = burgerReceiver;
        this.burgerStore = BurgerStore;
    }
    public void execute() {
        burger = new BeefBurger(burgerStore.getFactory());
        burgerReceiver.addBurger(burger, burgerStore);
    }
}

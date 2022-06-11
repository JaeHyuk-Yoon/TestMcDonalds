/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.SideMenu;
import src.DecoratorPattern.Milk;
import src.FactoryPattern.BurgerStore;

/**
 *
 * @author JaeHyuk
 */
public class SetMilkCommand implements Command {
    private SideMenuReceiver sideMenuReceiver;
    SideMenu sidemenu;
    BurgerStore burgerStore;
    
    public SetMilkCommand(SideMenuReceiver sideMenuReceiver, BurgerStore BurgerStore) {
        this.sideMenuReceiver = sideMenuReceiver;
        this.burgerStore = BurgerStore;
    }
    public void execute() {
        sidemenu =  new Milk();
        sideMenuReceiver.addSide(sidemenu);
    }
}

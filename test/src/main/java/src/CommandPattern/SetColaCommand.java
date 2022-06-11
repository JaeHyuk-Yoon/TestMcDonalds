/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.cola;
import src.DecoratorPattern.SideMenu;
import src.FactoryPattern.BurgerStore;

/**
 *
 * @author JaeHyuk
 */
public class SetColaCommand implements Command {
    private SideMenuReceiver sideMenuReceiver;
    SideMenu sidemenu;
    BurgerStore burgerStore;
    
    public SetColaCommand(SideMenuReceiver sideMenuReceiver, BurgerStore BurgerStore) {
        this.sideMenuReceiver = sideMenuReceiver;
        this.burgerStore = BurgerStore;
    }
    public void execute() {
        sidemenu =  new cola(burgerStore.getFactory());
        sideMenuReceiver.addSide(sidemenu);
    }
}

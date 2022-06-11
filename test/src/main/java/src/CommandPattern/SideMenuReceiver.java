/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.SideMenu;
import src.FactoryPattern.BurgerStore;


/**
 *
 * @author JaeHyuk
 */
public class SideMenuReceiver {
    public SideMenuReceiver() {
    }
    
    public SideMenu sideMenu;
    
    public void addSide(SideMenu sideMenu) {
        this.sideMenu = sideMenu;
    }
    
    public SideMenu getSideMenu() {
        return sideMenu;
    }
}

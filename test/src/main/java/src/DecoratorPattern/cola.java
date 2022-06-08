/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

import db.MenuDAO;
import db.StockDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.IndCola;

/**
 *
 * @author JaeHyuk
 */
public class cola extends SideMenudecorator{
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    SideMenu sidemenu;
    protected IndCola indCola;
    private BurgerStoreIngredientFactory ingregientFactory;
    
    public cola(SideMenu sidemenu, BurgerStoreIngredientFactory ingregientFactory) { 
        this.sidemenu = sidemenu;
        this.ingregientFactory = ingregientFactory;
        this.indCola = ingregientFactory.createCola();
    }
    
    public String getDescription() {
        //return sidemenu.getDescription() + "+콜라";
        return "콜라";
    }
    
    public int cost() { 
        try {
            cost = menuDAO.menuCost("콜라");
        } catch (SQLException ex) {
            Logger.getLogger(SideMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return cost + sidemenu.cost();
        return cost;
    }
    public void completeOrder(String branch) {
        StockDAO stockDAO2 = new StockDAO();
        stockDAO2.completeOrderQtySet(indCola.getIndCola(), branch);
    }
}

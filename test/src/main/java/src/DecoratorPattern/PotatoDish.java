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
import src.FactoryPattern.Potato;

/**
 *
 * @author JaeHyuk
 */
public class PotatoDish extends SideMenudecorator{
     MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    SideMenu sidemenu;
    protected Potato indPotato;
    private BurgerStoreIngredientFactory ingregientFactory;
    
    public PotatoDish(SideMenu sidemenu, BurgerStoreIngredientFactory ingregientFactory) {
        this.sidemenu = sidemenu;
        this.ingregientFactory = ingregientFactory;
        this.indPotato = ingregientFactory.createPotato();
    }
    
    public String getDescription() {
        //return sidemenu.getDescription() + "+포테이토";
        return "포테이토";
    }
    
    public int cost() { 
        try {
            cost = menuDAO.menuCost("포테이토");
        } catch (SQLException ex) {
            Logger.getLogger(SideMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return cost + sidemenu.cost();
        return cost;
    }
    
    public void completeOrder(String branch) {
        StockDAO stockDAO = new StockDAO();
        stockDAO.completeOrderQtySet(indPotato.getPotato(), branch); 
    }
}

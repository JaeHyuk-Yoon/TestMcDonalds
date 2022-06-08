/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

import src.DecoratorPattern.BurgerToppingdecorator;
import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.Burger;
import db.MenuDAO;
import db.StockDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.IndCola;
import src.FactoryPattern.Potato;

/**
 *
 * @author JaeHyuk
 */
public class ChangeSet extends BurgerToppingdecorator {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    Burger burger;
    protected Potato indPotato;
    protected IndCola indCola;
    private BurgerStoreIngredientFactory ingregientFactory;
    
    public ChangeSet(Burger burger, BurgerStoreIngredientFactory ingregientFactory) { 
        this.burger = burger;
        this.ingregientFactory = ingregientFactory;
        this.indPotato = ingregientFactory.createPotato();
        this.indCola = ingregientFactory.createCola();
    }
    public String getDescription() {
        return burger.getDescription() + "+세트";
    }
    public int cost() { 
        try {
            cost = menuDAO.menuCost("세트");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost + burger.cost();
    }
    
    public void completeOrder(String branch) {
        StockDAO stockDAO = new StockDAO();
        stockDAO.completeOrderQtySet(indPotato.getPotato(), branch);
        StockDAO stockDAO2 = new StockDAO();
        stockDAO2.completeOrderQtySet(indCola.getIndCola(), branch);
        burger.completeOrder(branch);
    }
}

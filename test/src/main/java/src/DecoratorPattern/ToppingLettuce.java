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
import src.FactoryPattern.Vegetable;

/**
 *
 * @author JaeHyuk
 */
public class ToppingLettuce extends BurgerToppingdecorator {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    Burger burger;
    public StockDAO stockDAO = new StockDAO();
    protected Vegetable indVegetable;
    private BurgerStoreIngredientFactory ingregientFactory;
    
    public ToppingLettuce(Burger burger, BurgerStoreIngredientFactory ingregientFactory) { 
        this.burger = burger;
        this.ingregientFactory = ingregientFactory;
        this.indVegetable = ingregientFactory.createVegetable();
    }
    public String getDescription() {
        return burger.getDescription() + "+야채";
    }
    public int cost() { 
         try {
            cost = menuDAO.menuCost("야채");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost + burger.cost();
    }
    
    public void completeOrder(String branch) {
        stockDAO.completeOrderQtySet(indVegetable.getVegetable(), branch);
        
        burger.completeOrder(branch);
    }
}

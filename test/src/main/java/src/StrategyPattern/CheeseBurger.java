/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.Burger;
import src.StrategyPattern.BeefBbqSauce;
import src.StrategyPattern.BeefPatty;
import src.StrategyPattern.AddCheese;
import db.MenuDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.FactoryPattern.BurgerStoreIngredientFactory;

/**
 *
 * @author JaeHyuk
 */
public class CheeseBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    public CheeseBurger() {
        description = "치즈 버거";
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        cheese = cheeseCheck();

        
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public CheeseBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 이부분 수정해야할듯
        description = "치즈 버거";
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        cheese = cheeseCheck();

    }

    public int cost() {
        try {
            cost = menuDAO.menuCost("치즈버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }

    public boolean cheeseCheck() {
        if (cheeseWheather.getCheeseWheather() == "치즈") {
            return true;
        } else {
            return false;
        }
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }

}

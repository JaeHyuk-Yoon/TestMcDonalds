/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import db.MenuDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author JaeHyuk
 */
public class ChickenBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    
    public ChickenBurger() {
        description = "치킨 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public ChickenBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 이부분 수정해야할듯
        description = "매운 치킨 버거";        
        selectPatty = new ChickenPatty();
        selectSauce = new ChickenBbqSauce();
        selectVegetable = new LettuceTomato();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();

    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("chickenBurger");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
}

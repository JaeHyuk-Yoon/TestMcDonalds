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
public class BeefBurger extends Burger {
    
    public MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    public BeefBurger() {
        description = "비프 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public BeefBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 이부분 수정해야할듯
        description = "비프 버거"; // 각각 사용하는 요소들만 + 추가하기       ex) 스토어 이름 + 원재료 나열 + 버거 종류
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new LettuceTomato();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        
        //this.indBun = ingregientFactory.createBun();
        //this.indCheese = ingregientFactory.createCheese();
        //this.indVegetable = ingregientFactory.createVegetable();
        //this.indPotato = ingregientFactory.createPotato();
        //this.indCola = ingregientFactory.createCola();
        //this.indBeefPatty = ingregientFactory.createBeefPatty();

    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("beefBurger");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
    
    @Override
    public String getDescription() {
        
//        this.indBun = ingregientFactory.createBun();
//        this.indCheese = ingregientFactory.createCheese();
//        this.indVegetable = ingregientFactory.createVegetable();
//        this.indPotato = ingregientFactory.createPotato();
//        this.indCola = ingregientFactory.createCola();
//        this.indBeefPatty = ingregientFactory.createBeefPatty();
        
        return description;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
}

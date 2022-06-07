/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.Burger;
import src.StrategyPattern.ChickenBbqSauce;
import src.StrategyPattern.ChickenPatty;
import db.MenuDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.FactoryPattern.Bun;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.Cheese;
import src.FactoryPattern.IndBeefPatty;
import src.FactoryPattern.IndCola;
import src.FactoryPattern.Potato;
import src.FactoryPattern.Vegetable;
/**
 *
 * @author JaeHyuk
 */
public class ChickenBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
    public ArrayList<String> ChickenBurgerind = new ArrayList<String>();
    
    public ChickenBurger() {
        description = "치킨 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public ChickenBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 스트레티지 구현 부분
        description = "매운 치킨 버거";        
        selectPatty = new ChickenPatty();
        selectSauce = new ChickenBbqSauce();
        selectVegetable = new LettuceTomato();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();

        //팩토리 패턴 구현 부분
        this.indBun = ingregientFactory.createBun();
        ChickenBurgerind.add(indBun.getBun());
        
        this.indCheese = ingregientFactory.createCheese();
        ChickenBurgerind.add(indCheese.getCheese());
        
        this.indVegetable = ingregientFactory.createVegetable();
        ChickenBurgerind.add(indVegetable.getVegetable());
        
        this.indPotato = ingregientFactory.createPotato();
        ChickenBurgerind.add(indPotato.getPotato());
        
        this.indCola = ingregientFactory.createCola();
        ChickenBurgerind.add(indCola.getIndCola());
        
        this.indBeefPatty = ingregientFactory.createBeefPatty();
        ChickenBurgerind.add(indBeefPatty.getIndBeefPatty());
        
    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("치킨버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
    
    public ArrayList<String> getBeefBurgerInd() {
        return (ChickenBurgerind);
    }
}

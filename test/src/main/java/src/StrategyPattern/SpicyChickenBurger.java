/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.LettuceTomato;
import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.Burger;
import src.StrategyPattern.SpicyChickenBbqSauce;
import src.StrategyPattern.ChickenPatty;
import db.MenuDAO;
import db.StockDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.DecoratorPattern.Menu;
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
public class SpicyChickenBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    
    
    int cost = 0;
    
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
    String branch;
    //해당 버거에 사용된 기본 원재료들을 담기위한 ArrayList
    public ArrayList<String> SpicyChickenBurgerind = new ArrayList<String>();
    
    public SpicyChickenBurger() {
        description = "매운 치킨 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public SpicyChickenBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        description = "매운 치킨 버거";  
        // 스트레티지 구현 부분(버거에서 메뉴에 따라 변하는 부분)
        selectPatty = new ChickenPatty();
        selectSauce = new SpicyChickenBbqSauce();
        selectVegetable = new LettuceTomato();
        
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        
        SpicyChickenBurgerind.add(patty);
        SpicyChickenBurgerind.add(sauce);
        
        //팩토리 패턴 구현 부분
        this.indBun = this.ingregientFactory.createBun();
        SpicyChickenBurgerind.add(indBun.getBun());
        
        this.indVegetable = this.ingregientFactory.createVegetable();
        SpicyChickenBurgerind.add(indVegetable.getVegetable());
    }
    
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("매운치킨버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
   
    public void completeOrder(String branch) {
        for(String ind : SpicyChickenBurgerind) {
            StockDAO stockDAO = new StockDAO();
            this.branch = branch;
            stockDAO.completeOrderQtySet(ind, branch);
        }
    }
}

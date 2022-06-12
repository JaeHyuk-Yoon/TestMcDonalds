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
import db.StockDAO;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.DecoratorPattern.Menu;
import src.FactoryPattern.Bun;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.Cheese;
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
    
    String branch;
    //해당 버거에 사용된 기본 원재료들을 담기위한 ArrayList
    public ArrayList<String> ChickenBurgerind = new ArrayList<String>();
    
    public ChickenBurger() {
        description = "치킨 버거";
    }

    public ChickenBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        description = "치킨 버거";        
        // 스트레티지 구현 부분(버거에서 메뉴에 따라 변하는 부분)
        selectPatty = new ChickenPatty();
        selectSauce = new ChickenBbqSauce();
        selectVegetable = new LettuceTomato();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();

        ChickenBurgerind.add(patty);
        ChickenBurgerind.add(sauce);
        
        //팩토리 패턴 구현 부분
        this.indBun = this.ingregientFactory.createBun();
        ChickenBurgerind.add(indBun.getBun());
        
        this.indVegetable = this.ingregientFactory.createVegetable();
        ChickenBurgerind.add(indVegetable.getVegetable());
        
    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("치킨버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
    
    //버거 주문 내역 생성하기위한 메서드
    @Override
    public String getDescription() {
        return description;
    }
    
    public void completeOrder(String branch) {
        for(String ind : ChickenBurgerind) {
            StockDAO stockDAO = new StockDAO();
            this.branch = branch;
            stockDAO.completeOrderQtySet(ind, branch);
        }
    }
}

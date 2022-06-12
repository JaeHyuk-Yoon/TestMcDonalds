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
public class CheeseBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    
    int cost = 0;
    
    String branch;
    //해당 버거에 사용된 기본 원재료들을 담기위한 ArrayList
    public ArrayList<String> CheeseBurgerind = new ArrayList<String>();
    
    public CheeseBurger() {
        description = "치즈 버거";
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();        
    }

    public CheeseBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        description = "치즈 버거";
        // 스트레티지 구현 부분(버거에서 메뉴에 따라 변하는 부분)
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        
        CheeseBurgerind.add(patty);
        CheeseBurgerind.add(sauce);
        
        //팩토리 패턴 구현 부분
        this.indBun = this.ingregientFactory.createBun();
        CheeseBurgerind.add(indBun.getBun());
        
        this.indCheese = this.ingregientFactory.createCheese();
        CheeseBurgerind.add(indCheese.getCheese());
    }

    public int cost() {
        try {
            cost = menuDAO.menuCost("치즈버거");
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
        for(String ind : CheeseBurgerind) {
            StockDAO stockDAO = new StockDAO();
            this.branch = branch;
            stockDAO.completeOrderQtySet(ind, branch);
        }
    }
}

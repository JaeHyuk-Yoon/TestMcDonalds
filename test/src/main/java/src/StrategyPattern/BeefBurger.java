/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.Burger;
import src.StrategyPattern.BeefBbqSauce;
import src.StrategyPattern.BeefPatty;
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
public class BeefBurger extends Burger {
    
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
    public ArrayList<String> BeefBurgerind = new ArrayList<String>();
    
    public BeefBurger() {
        description = "비프 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public BeefBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        
        description = "비프 버거"; // 각각 사용하는 요소들만 + 추가하기       ex) 스토어 이름 + 원재료 나열 + 버거 종류
        // 스트레티지 구현 부분(버거에서 메뉴에 따라 변하는 부분)
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        
        BeefBurgerind.add(sauce);
        BeefBurgerind.add(patty);
        
        //팩토리 패턴으로 매장에따른 원재료 구분
        this.indBun = this.ingregientFactory.createBun();
        BeefBurgerind.add(indBun.getBun());
    }
    
    //주문 금액을 생성하기위한 메서드
    public int cost() {
        try {
            cost = menuDAO.menuCost("비프버거");
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

    public ArrayList<String> getBurgerInd() {
        return (BeefBurgerind);
    }
   
    //OrderFrame에서 주문완료 버튼을 눌렀을때 실행되어 완성되어 장바구니에 담긴 
    //메뉴에대해 stockDAO의 객체에서 해당 매장에 따른 원재료값만 사용한만큼 줄이는 메서드
    public void completeOrder(String branch) {
        for(String ind : BeefBurgerind) {
            StockDAO stockDAO = new StockDAO();
            this.branch = branch;
            stockDAO.completeOrderQtySet(ind, branch);
        }
    }
}

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
 * 클래스 역할 : 데코레이터 패턴을 사용하여 버거를 세트 메뉴로 변경할지 동적추가될 객체 역할
 */
public class ChangeSet extends BurgerToppingdecorator {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    Burger burger;
    protected Potato indPotato;
    protected IndCola indCola;
    private BurgerStoreIngredientFactory ingregientFactory;
    
    //세트메뉴로 변경할 버거와 해당 매장의 팩토리를 받아와 필요한 원재료를 객체를 생성하여 해당 객체에 담는 생성자
    public ChangeSet(Burger burger, BurgerStoreIngredientFactory ingregientFactory) { 
        this.burger = burger;
        this.ingregientFactory = ingregientFactory;
        this.indPotato = ingregientFactory.createPotato();
        this.indCola = ingregientFactory.createCola();
    }
    //버거 주문 내역 생성하기위한 메서드
    public String getDescription() {
        return burger.getDescription() + "+세트";
    }
    //세트로 변경했을 때 금액을 추가하여 리턴시키는 메서드
    public int cost() { 
        try {
            cost = menuDAO.menuCost("세트");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost + burger.cost();
    }
    
    //OrderFrame에서 주문완료 버튼을 눌렀을때 실행되어 완성되어 장바구니에 담긴 
    //메뉴에대해 stockDAO의 객체에서 해당 매장에 따른 원재료값을 사용한만큼 줄이기고
    //데코레이터에서 자신을 담고있는 다음 객체의 completeOrder메서드를 실행시키는 메서드
    public void completeOrder(String branch) {
        StockDAO stockDAO = new StockDAO();
        stockDAO.completeOrderQtySet(indPotato.getPotato(), branch);
        StockDAO stockDAO2 = new StockDAO();
        stockDAO2.completeOrderQtySet(indCola.getIndCola(), branch);
        burger.completeOrder(branch);
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

import db.MenuDAO;
import db.StockDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : 사이드메뉴중 치즈스틱 객체
 */
public class CheeseStick extends SideMenudecorator {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    public CheeseStick() { }
    
    //버거 주문 내역 생성하기위한 메서드
    public String getDescription() {
        return "치즈스틱";
    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("치즈스틱");
        } catch (SQLException ex) {
            Logger.getLogger(SideMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return cost + sidemenu.cost();
        return cost;
    }
    //OrderFrame에서 주문완료 버튼을 눌렀을때 실행되어 완성되어 장바구니에 담긴 
    //메뉴에대해 stockDAO의 객체에서 해당 매장에 따른 원재료값을 사용한만큼 줄이기고
    //데코레이터에서 자신을 담고있는 다음 객체의 completeOrder메서드를 실행시키는 메서드
    public void completeOrder(String branch) {
        StockDAO stockDAO = new StockDAO();
        stockDAO.completeOrderQtySet(getDescription(), branch);
    }
}

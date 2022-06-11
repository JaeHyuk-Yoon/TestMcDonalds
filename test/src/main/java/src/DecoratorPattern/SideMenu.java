/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

import db.MenuDAO;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.StrategyPattern.CheeseBurger;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : 사이드메뉴중 포테이토음식 객체
 */
public abstract class SideMenu extends Menu{
    int cost = 0;
    SideMenu sidemenu;
    public String description = "";
    
     public String getDescription() {
        return description;
    }
    
    public int cost() {
        return cost;
    }
    public abstract void completeOrder(String branch);
    
    
}

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

/**
 *
 * @author JaeHyuk
 */
public class cola extends SideMenudecorator{
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    SideMenu sidemenu;
    public cola(SideMenu sidemenu) { this.sidemenu = sidemenu;}
    
    public String getDescription() {
        //return sidemenu.getDescription() + "+콜라";
        return "콜라";
    }
    
    public int cost() { 
        try {
            cost = menuDAO.menuCost("cola");
        } catch (SQLException ex) {
            Logger.getLogger(SideMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //return cost + sidemenu.cost();
        return cost;
    }
}

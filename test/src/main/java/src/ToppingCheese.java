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
public class ToppingCheese extends BurgerToppingdecorator {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    Burger burger;
    public ToppingCheese(Burger burger) { this.burger = burger;}
    public String getDescription() {
        return burger.getDescription() + ", add ToppingCheese";
    }
    public int cost() { 
        try {
            cost = menuDAO.menuCost("cheese");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost + burger.cost();}
    
}

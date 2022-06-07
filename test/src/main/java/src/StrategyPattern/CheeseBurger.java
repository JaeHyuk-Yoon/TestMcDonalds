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
public class CheeseBurger extends Burger {
    MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
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
        cheese = cheeseCheck();

        
        
        
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public CheeseBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 스트레티지 구현 부분
        description = "치즈 버거";
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        cheese = cheeseCheck();
        
        //팩토리 패턴 구현 부분
        this.indBun = ingregientFactory.createBun();
        CheeseBurgerind.add(indBun.getBun());
        
        this.indCheese = ingregientFactory.createCheese();
        CheeseBurgerind.add(indCheese.getCheese());
        
        this.indVegetable = ingregientFactory.createVegetable();
        CheeseBurgerind.add(indVegetable.getVegetable());
        
        this.indPotato = ingregientFactory.createPotato();
        CheeseBurgerind.add(indPotato.getPotato());
        
        this.indCola = ingregientFactory.createCola();
        CheeseBurgerind.add(indCola.getIndCola());
        
        this.indBeefPatty = ingregientFactory.createBeefPatty();
        CheeseBurgerind.add(indBeefPatty.getIndBeefPatty());
        
    }

    public int cost() {
        try {
            cost = menuDAO.menuCost("치즈버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }

    public boolean cheeseCheck() {
        if (cheeseWheather.getCheeseWheather() == "치즈") {
            return true;
        } else {
            return false;
        }
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
    
    public ArrayList<String> getBeefBurgerInd() {
        return (CheeseBurgerind);
    }

}

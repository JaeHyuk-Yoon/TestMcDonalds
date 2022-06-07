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
public class BeefBurger extends Burger {
    
    public MenuDAO menuDAO = new MenuDAO();
    int cost = 0;
    
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
    public ArrayList<String> BeefBurgerind = new ArrayList<String>();
    
    public BeefBurger() {
        description = "비프 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public BeefBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 스트레티지 구현 부분
        description = "비프 버거"; // 각각 사용하는 요소들만 + 추가하기       ex) 스토어 이름 + 원재료 나열 + 버거 종류
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        
        //팩토리 패턴 구현 부분
        this.indBun = ingregientFactory.createBun();
        BeefBurgerind.add(indBun.getBun());
        
        this.indCheese = ingregientFactory.createCheese();
        BeefBurgerind.add(indCheese.getCheese());
        
        this.indVegetable = ingregientFactory.createVegetable();
        BeefBurgerind.add(indVegetable.getVegetable());
        
        this.indPotato = ingregientFactory.createPotato();
        BeefBurgerind.add(indPotato.getPotato());
        
        this.indCola = ingregientFactory.createCola();
        BeefBurgerind.add(indCola.getIndCola());
        
        this.indBeefPatty = ingregientFactory.createBeefPatty();
        BeefBurgerind.add(indBeefPatty.getIndBeefPatty());
        
    }
    
    public int cost() {
        try {
            cost = menuDAO.menuCost("비프버거");
        } catch (SQLException ex) {
            Logger.getLogger(CheeseBurger.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cost;
    }
    
    @Override
    public String getDescription() {
        return description;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
    
    public ArrayList<String> getBeefBurgerInd() {
        return (BeefBurgerind);
    }
}

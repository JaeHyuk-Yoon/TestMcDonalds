/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import java.util.ArrayList;
import src.FactoryPattern.SnGBurgerIngredientFactory;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.SpicyChickenBurger;
import src.StrategyPattern.ChickenBurger;
import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.BeefBurger;
import src.StrategyPattern.Burger;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class SnGBurgerStore extends BurgerStore {
    // 팩토리 원재료군
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
    public ArrayList<String> ind = new ArrayList<String>();
    
    Burger burger;
    BurgerStoreIngredientFactory factory;
    
     public SnGBurgerStore() {
        BurgerStoreIngredientFactory factory = new GuilguBurgerIngredientFactory();
        this.indBun = factory.createBun();
        ind.add(indBun.getBun());
        
        this.indCheese = factory.createCheese();
        ind.add(indCheese.getCheese());
        
        this.indVegetable = factory.createVegetable();
        ind.add(indVegetable.getVegetable());
        
        this.indPotato = factory.createPotato();
        ind.add(indPotato.getPotato());
        
        this.indCola = factory.createCola();
        ind.add(indCola.getIndCola());
        
        this.indBeefPatty = factory.createBeefPatty();
        ind.add(indBeefPatty.getIndBeefPatty());
    }
    
    @Override
    public Burger createBurger(String item) {
        Burger burger = null;
        BurgerStoreIngredientFactory factory = new SnGBurgerIngredientFactory();
        
        if(item.equals("치즈 버거")) {
            burger = new CheeseBurger(factory);
            burger.setDescription("(SnG 매장) : 치즈 버거");
        } else if(item.equals("비프 버거")) {
            burger = new BeefBurger(factory);
            burger.setDescription("(SnG 매장) : 비프 버거");
        } else if(item.equals("치킨 버거")) {
            burger = new ChickenBurger(factory);
            burger.setDescription("(SnG 매장) : 치킨 버거");
        } else if(item.equals("매운 치킨 버거")) {
            burger = new SpicyChickenBurger(factory);
            burger.setDescription("(SnG 매장) : 매운 치킨 버거");
        }
        
        return burger;
    }
    
    public ArrayList<String> getTotalStoreInd() {
        return (ind);
    }
    public BurgerStoreIngredientFactory getFactory() {
        return factory;
    }
}

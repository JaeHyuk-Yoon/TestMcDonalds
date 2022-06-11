/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.GuilguBurgerIngredientFactory;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.SpicyChickenBurger;
import src.StrategyPattern.ChickenBurger;
import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.BeefBurger;
import src.StrategyPattern.Burger;
import java.util.ArrayList;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class GuilguBurgerStore extends BurgerStore{
    // 팩토리 원재료군
    protected Bun indBun;
    protected Cheese indCheese;
    protected Vegetable indVegetable;
    protected Potato indPotato;
    protected IndCola indCola;
    protected IndBeefPatty indBeefPatty;
    
    Burger burger;
    public BurgerStoreIngredientFactory factory;
    
    //919매장에서 사용되는 총 원재료객체를 생성하여 가지고옴
    public GuilguBurgerStore() {
        factory = new GuilguBurgerIngredientFactory();
        this.indBun = factory.createBun();
        
        this.indCheese = factory.createCheese();
        
        this.indVegetable = factory.createVegetable();
        
        this.indPotato = factory.createPotato();
        
        this.indCola = factory.createCola();
        
        this.indBeefPatty = factory.createBeefPatty();
      
    }
    
    //919매장의 팩토리를 가져오는 메서드
    public BurgerStoreIngredientFactory getFactory() {
        return factory;
    }
}

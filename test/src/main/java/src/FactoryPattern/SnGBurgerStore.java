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
    
    public BurgerStoreIngredientFactory factory;
    
    //SnG매장에서 사용되는 총 원재료객체를 생성하여 가지고옴
     public SnGBurgerStore() {
        factory = new SnGBurgerIngredientFactory();
        this.indBun = factory.createBun();
        
        this.indCheese = factory.createCheese();
        
        this.indVegetable = factory.createVegetable();
        
        this.indPotato = factory.createPotato();
        
        this.indCola = factory.createCola();
        
    }
     
     //SnG매장의 팩토리를 가져오는 메서드
    public BurgerStoreIngredientFactory getFactory() {
        return factory;
    }
}

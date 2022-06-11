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
    public BurgerStoreIngredientFactory factory;
    
     public SnGBurgerStore() {
        factory = new SnGBurgerIngredientFactory();
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
        
        // (커맨드 창 확인용) 인터페이스 사용하여 get 하나로 묶고 타입도 묶어서 for문으로 출력하도록 바꾸기
//        System.out.println("//팩토리 패턴 구현 부분");
//        System.out.println("'"+indBun.getBun()+"' '"+indCheese.getCheese()+"' '"+indVegetable.getVegetable()
//          +"' '"+ indPotato.getPotato() +"' '"+ indCola.getIndCola()+"' '"+ indBeefPatty.getIndBeefPatty()+"'");
//        System.out.println("");
    }
     
//    @Override
//    public Burger createBurger(Burger burger) {
//        this.burger = burger;
//        
//        return burger;
//    }
    
    public ArrayList<String> getTotalStoreInd() {
        return (ind);
    }
    public BurgerStoreIngredientFactory getFactory() {
        return factory;
    }
}

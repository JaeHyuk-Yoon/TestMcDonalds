/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.GuilguBurgerIngredientFactory;
import src.FactoryPattern.Cheese;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.BurgerStore;
import src.FactoryPattern.Bun;
import src.StrategyPattern.SpicyChickenBurger;
import src.StrategyPattern.ChickenBurger;
import src.StrategyPattern.CheeseBurger;
import src.StrategyPattern.BeefBurger;
import src.StrategyPattern.Burger;

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
    BurgerStoreIngredientFactory factory;
        
    public GuilguBurgerStore() {
        BurgerStoreIngredientFactory factory = new GuilguBurgerIngredientFactory();
        this.indBun = factory.createBun();
        this.indCheese = factory.createCheese();
        this.indVegetable = factory.createVegetable();
        this.indPotato = factory.createPotato();
        this.indCola = factory.createCola();
        this.indBeefPatty = factory.createBeefPatty();
        //인터페이스 사용하여 get 하나로 묶고 타입도 묶어서 for문으로 출력하도록 바꾸기
        System.out.println("//팩토리 패턴 구현 부분");
        System.out.println("'"+indBun.getBun()+"' '"+indCheese.getCheese()+"' '"+indVegetable.getVegetable()
          +"' '"+ indPotato.getPotato() +"' '"+ indCola.getIndCola()+"' '"+ indBeefPatty.getIndBeefPatty()+"'");
        System.out.println("");
    }
    
    @Override
    public Burger createBurger(String item) {
        
        if(item.equals("치즈 버거")) {
            burger = new CheeseBurger(factory);
            burger.setDescription("(919 매장) : 치즈 버거");
        } else if(item.equals("비프 버거")) {
            burger = new BeefBurger(factory);
            burger.setDescription("(919 매장) : 비프 버거");
        } else if(item.equals("치킨 버거")) {
            burger = new ChickenBurger(factory);
            burger.setDescription("(919 매장) : 치킨 버거");
        } else if(item.equals("매운 치킨 버거")) {
            burger = new SpicyChickenBurger(factory);
            burger.setDescription("(919 매장) : 매운 치킨 버거");
        }
        else {
            System.out.println("버거 다시 입력 하이소.");
        }
        
        return burger;
    }
}

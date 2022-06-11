/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.Potato;
import src.FactoryPattern.MozzarellaCheese;
import src.FactoryPattern.Medium;
import src.FactoryPattern.IndCola;
import src.FactoryPattern.IndCocaCola;
import src.FactoryPattern.IndBeefPatty;
import src.FactoryPattern.HashBrown;
import src.FactoryPattern.Cheese;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.Bun;
import src.FactoryPattern.BlackBun;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class SnGBurgerIngredientFactory implements BurgerStoreIngredientFactory{
    
    public SnGBurgerIngredientFactory() {
        System.out.println(" SnG 매장 입장 !");
        System.out.println("------------------------------( 919 매장내 사용되는 식자재 종류, 메뉴형식, 출력되지 않는것들은 다른 매장과 동일 )-------------------------------");
        System.out.println("");
    }
    
    @Override
    public Bun createBun() {
        return new BlackBun();
    }

    @Override
    public Cheese createCheese() {
        return new MozzarellaCheese();
    }

    @Override
    public Potato createPotato() {
        return new HashBrown();
    }

    @Override
    public Vegetable createVegetable() {
        return new SnGVegetable();
    }
    
    @Override
    public IndCola createCola() {
        return new IndCocaCola();
    }
    
    @Override
    public IndBeefPatty createBeefPatty() {
        return new Medium();
    }
    
    public String getFactoryName() {
        return "SnG";
    }
    
}

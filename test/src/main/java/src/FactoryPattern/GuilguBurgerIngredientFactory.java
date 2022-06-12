/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.Cheese;
import src.FactoryPattern.CheddarCheese;
import src.FactoryPattern.BurgerStoreIngredientFactory;
import src.FactoryPattern.Bun;
import src.FactoryPattern.BasicBun;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class GuilguBurgerIngredientFactory implements BurgerStoreIngredientFactory{

    
    public GuilguBurgerIngredientFactory() {
        System.out.println(" 919 매장 입장 !");
    }
    @Override
    public Bun createBun() {
        return new BasicBun();
    }

    @Override
    public Cheese createCheese() {
        return new CheddarCheese();
    }

    @Override
    public Potato createPotato() {
        return new PotatoWedges();
    }

    @Override
    public Vegetable createVegetable() {
        return new GuilguVegetable();
    }

    @Override
    public IndCola createCola() {
        return new IndPepsiCola();
    }
    
    public String getFactoryName() {
        return "919";
    }
}

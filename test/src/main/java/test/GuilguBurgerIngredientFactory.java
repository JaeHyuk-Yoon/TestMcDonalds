/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class GuilguBurgerIngredientFactory implements BurgerStoreIngredientFactory{

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
    public Cola createCola() {
        return new PepsiCola();
    }
    
}

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
public class SnGBurgerIngredientFactory implements BurgerStoreIngredientFactory{

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
    public Cola createCola() {
        return new CocaCola();
    }
    
}

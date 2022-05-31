/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 * 
 * 다 저장해두고 필요하는 것만 가져다 사용할 것임
 */
public interface BurgerStoreIngredientFactory {
    Bun createBun();
    Cheese createCheese();
    Potato createPotato();
    Vegetable createVegetable();
    IndCola createCola();    
}

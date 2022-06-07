/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class GuilguBurgerIngredientFactory implements BurgerStoreIngredientFactory{

    
    public GuilguBurgerIngredientFactory() {
        System.out.println(" 919 매장 입장 !");
        System.out.println("------------------------------( 919 매장내 사용되는 식자재 종류, 메뉴형식, 출력되지 않는것들은 다른 매장과 동일 )-------------------------------");
        System.out.println("");
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
    
    @Override
    public IndBeefPatty createBeefPatty() {
        return new MediumRare();
    }
    
}

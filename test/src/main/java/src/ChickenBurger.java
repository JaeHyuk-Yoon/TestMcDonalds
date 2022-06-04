/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author JaeHyuk
 */
public class ChickenBurger extends Burger {
    public ChickenBurger() {
        description = "치킨 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public ChickenBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 이부분 수정해야할듯
        description = "매운 치킨 버거";        
        selectPatty = new ChickenPatty();
        selectSauce = new ChickenBbqSauce();
        selectVegetable = new LettuceTomato();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();

    }
    
    public int cost() {
        return 4000;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
}

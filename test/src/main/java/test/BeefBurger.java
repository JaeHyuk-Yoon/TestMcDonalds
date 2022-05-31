/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author JaeHyuk
 */
public class BeefBurger extends Burger {
    public BeefBurger() {
        description = "비프 버거";
    }
    
    private BurgerStoreIngredientFactory ingregientFactory;

    public BeefBurger(BurgerStoreIngredientFactory ingregientFactory) {
        this.ingregientFactory = ingregientFactory;
        
        // 이부분 수정해야할듯
        description = "비프 버거";        
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new LettuceTomato();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();

    }
    
    public int cost() {
        return 4500;
    }
    
    @Override
    public String getDescription() {
        
        this.indBun = ingregientFactory.createBun();
        this.indCheese = ingregientFactory.createCheese();
        this.indVegetable = ingregientFactory.createVegetable();
        this.indPotato = ingregientFactory.createPotato();
        this.indCola = ingregientFactory.createCola();
        this.indBeefPatty = ingregientFactory.createBeefPatty();
        
        return description;
    }
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
}

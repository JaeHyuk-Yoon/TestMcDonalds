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
public class CheeseBurger extends Burger {

    public CheeseBurger() {
        description = "치즈 버거";
        cheeseWheather = new AddCheese();
        selectPatty = new BeefPatty();
        selectSauce = new BeefBbqSauce();
        selectVegetable = new NoVegetable();
        patty = selectPatty.getPatty();
        sauce = selectSauce.getSauce();
        vegetable = selectVegetable.getVegetable();
        cheese = cheeseCheck();

        
    }

    public int cost() {
        return 5000;
    }

    public boolean cheeseCheck() {
        if (cheeseWheather.getCheeseWheather() == "치즈 필요") {
            return true;
        } else {
            return false;
        }
    }
    
    public String testDisplay() {
        return description + patty + sauce + vegetable + cheeseWheather.getCheeseWheather();
    }

}

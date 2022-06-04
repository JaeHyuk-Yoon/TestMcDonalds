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
public abstract class BurgerToppingdecorator extends Burger{
    public abstract String getDescription();
    
    public String testDisplay() {
        return " '" + description + "' '" + patty + "' '" + sauce + "' '" + vegetable + "' '" + cheeseWheather.getCheeseWheather()+ "'";
    }
}

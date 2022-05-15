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
public class ChickenBurger extends Burger {
    public ChickenBurger() {
        description = "치킨 버거";
    }
    
    public int cost() {
        return 4000;
    }
}

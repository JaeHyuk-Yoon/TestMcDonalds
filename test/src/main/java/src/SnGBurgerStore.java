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
public class SnGBurgerStore extends BurgerStore {
    
    @Override
    public Burger createBurger(String item) {
        Burger burger = null;
        BurgerStoreIngredientFactory factory = new SnGBurgerIngredientFactory();
        
        if(item.equals("치즈 버거")) {
            burger = new CheeseBurger(factory);
            burger.setDescription("(SnG 매장) : 치즈 버거");
        } else if(item.equals("비프 버거")) {
            burger = new BeefBurger(factory);
            burger.setDescription("(SnG 매장) : 비프 버거");
        } else if(item.equals("치킨 버거")) {
            burger = new ChickenBurger(factory);
            burger.setDescription("(SnG 매장) : 치킨 버거");
        } else if(item.equals("매운 치킨 버거")) {
            burger = new SpicyChickenBurger(factory);
            burger.setDescription("(SnG 매장) : 매운 치킨 버거");
        }
        
        return burger;
    }
}

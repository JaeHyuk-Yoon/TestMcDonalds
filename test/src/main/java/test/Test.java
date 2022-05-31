/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;


/**
 *
 * @author JaeHyuk
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        //CheeseBurger burger = new CheeseBurger();
        //System.out.print(burger.testDisplay());   // 스트레티지 패턴 테스트
        
        Burger burger2 = new CheeseBurger();
        //System.out.println(burger2.getDescription() + " 금액 : " + burger2.cost() +" 원");      //데코레이터 패턴 테스트
        
        Burger burger3 = new CheeseBurger();
        burger3 = new ToppingCheese(burger3);
        burger3 = new ToppingLettuce(burger3);
        burger3 = new ChangeSet(burger3);
        //System.out.println(burger3.getDescription() + " 금액 : " + burger3.cost() +"원");      //데코레이터 패턴 테스트
        
        Burger burger4 = new BeefBurger();
        burger4 = new ToppingCheese(burger4);
        burger4 = new ToppingLettuce(burger4);
        burger4 = new ChangeSet(burger4);
        //System.out.println(burger4.getDescription() + " 금액 : " + burger4.cost() +"원");      //데코레이터 패턴 테스트
        
        ArrayList<Menu> arrayMenu = new ArrayList<>();
        arrayMenu.add(burger2);
        arrayMenu.add(burger3);
        arrayMenu.add(burger4);
        
        for(Menu menu : arrayMenu) {
            System.out.println(menu.getDescription() + " 금액 : " + menu.cost() +"원");
        }
        
        // 팩토리 패턴 테스트
        Menu burger = null;
        BurgerStore sngBurgerStore = new SnGBurgerStore();
        BurgerStore guilguBurgerStore = new GuilguBurgerStore();
        
        burger = sngBurgerStore.orderBurger("치즈 버거");
        System.out.println("--------------------------");
        burger = guilguBurgerStore.orderBurger("비프 버거");
        
    }
    
}

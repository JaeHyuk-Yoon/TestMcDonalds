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
        
        //Burger burger2 = new CheeseBurger();
        //System.out.println(burger2.getDescription() + " 금액 : " + burger2.cost() +" 원");      //데코레이터 패턴 테스트
        
        //Burger burger3 = new CheeseBurger();
        //burger3 = new ToppingCheese(burger3);
        //burger3 = new ToppingLettuce(burger3);
        //burger3 = new ChangeSet(burger3);
        //System.out.println(burger3.getDescription() + " 금액 : " + burger3.cost() +"원");      //데코레이터 패턴 테스트
        
        //Burger burger4 = new BeefBurger();
        //burger4 = new ToppingCheese(burger4);
        //burger4 = new ToppingLettuce(burger4);
        //burger4 = new ChangeSet(burger4);
        //System.out.println(burger4.getDescription() + " 금액 : " + burger4.cost() +"원");      //데코레이터 패턴 테스트
        
        //ArrayList<Menu> arrayMenu = new ArrayList<>();
        //arrayMenu.add(burger2);
        //arrayMenu.add(burger3);
        //arrayMenu.add(burger4);
        
        //for(Menu menu : arrayMenu) {
        //    System.out.println(menu.getDescription() + " - 금액 : " + menu.cost() +"원");
        //}
        
        // 팩토리 패턴 테스트
//        Burger burger5 = null;
//        
//        BurgerStore sngBurgerStore = new SnGBurgerStore();
//        BurgerStore guilguBurgerStore = new GuilguBurgerStore();
//        
//        System.out.println("----------------------------------------------( 주문 )--------------------------------------------------");
//        burger5 = guilguBurgerStore.orderBurger("비프 버거");
//        burger5 = new ToppingCheese(burger5);
//        burger5= new ToppingLettuce(burger5);
//        burger5 = new ChangeSet(burger5);
 //      System.out.println(burger5.getDescription() + " - 금액 : " + burger5.cost() +"원");
       
        //옵저버
        OrderData orderData = new OrderData();
        StockDisplay stockDisplay = new StockDisplay(orderData);
        SalesDisplay salesDisplay = new SalesDisplay(orderData);
        OrderListDisplay orderListDisplay = new OrderListDisplay(orderData);
        
        orderData.setOrder("치즈버거세트", 6700);
        System.out.println("========================");
        orderData.setOrder("치즈스틱", 2000);
        System.out.println("========================");
        orderData.setOrder("매운치킨버거",5600);
        System.out.println("========================");

            
    }
    
}

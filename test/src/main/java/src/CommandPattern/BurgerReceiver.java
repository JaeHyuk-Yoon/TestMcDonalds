/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.ChangeSet;
import src.DecoratorPattern.ToppingCheese;
import src.DecoratorPattern.ToppingLettuce;
import src.FactoryPattern.BurgerStore;
import src.StrategyPattern.Burger;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : Command패턴에서 리시버 역할
 */
public class BurgerReceiver {
    public BurgerReceiver() {
    }
    
    public Burger burger;
    private BurgerStore burgerStore;
    int cn =0;//치즈토핑
    int vn =0;//야채토핑
    int setc =0;//세트변경
    
    // 고른 버거를 버거리시버에 담는 메서드
    public void addBurger(Burger burger, BurgerStore burgerStore) {
        this.burger = burger;
        this.burgerStore = burgerStore;
    }
    
    //토핑 추가 메서드
    public void setBurger(int cn, int vn, int setc) {
        this.cn = cn;
        this.vn = vn;
        this.setc = setc;
        //토핑 선택된 갯수만큼 데코레이터로 감싸기
        if(cn>0){
            for(int i=0 ; i < cn ; i++){
                burger = new ToppingCheese(burger, burgerStore.getFactory());
            }
        }
        if(vn>0){
            for(int i=0 ; i < vn ; i++){
                burger = new ToppingLettuce(burger, burgerStore.getFactory());
            }
        }
        if(setc == 1){
            burger = new ChangeSet(burger, burgerStore.getFactory());
        }
    }
    
    //데코레이터 패턴으로 토핑까지 추가된 버거 가져오게하는 메서드
    public Burger getBurger() {
        return burger;
    }
}

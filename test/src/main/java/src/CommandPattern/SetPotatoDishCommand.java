/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.PotatoDish;
import src.DecoratorPattern.SideMenu;
import src.FactoryPattern.BurgerStore;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : Command패턴에서 ConcreteCommand 역할
 */
public class SetPotatoDishCommand implements Command {
    private SideMenuReceiver sideMenuReceiver;
    SideMenu sidemenu;
    BurgerStore burgerStore;
    
    //해당 객체의 생성자로써 리시버를 설정하는 메서드
    public SetPotatoDishCommand(SideMenuReceiver sideMenuReceiver, BurgerStore BurgerStore) {
        this.sideMenuReceiver = sideMenuReceiver;
        this.burgerStore = BurgerStore;
    }
    //들어온 매장에 따라 다른 음식를 제공하는 포테이토음식 객체 생성하여 리시버로 전달
    public void execute() {
        sidemenu =  new PotatoDish(burgerStore.getFactory());
        sideMenuReceiver.addSide(sidemenu);
    }
}

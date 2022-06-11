/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

import src.StrategyPattern.Burger;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : 데코레이터 패턴에서 데코레이터 인터페이스 역할
 */
public abstract class BurgerToppingdecorator extends Burger{
    
    //해당 클래스를 상속받는 클래스에서는 모두 필수적으로 정의하여야함을 명시
    public abstract String getDescription();
    
}

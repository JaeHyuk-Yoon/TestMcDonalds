/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.DecoratorPattern;

/**
 *
 * @author JaeHyuk
 * * 클래스 역할 : 타입이 다른 버거메뉴와 사이드메뉴를 하나의 배열에 담기위한 클래스
 */
public abstract class Menu {
    public String description = "제목없음";
    
    public String getDescription() {
        return description;
    }
    public abstract int cost();

    public void setDescription(String description) {
        this.description = description;
    }
    public abstract void completeOrder(String branch);
    
}

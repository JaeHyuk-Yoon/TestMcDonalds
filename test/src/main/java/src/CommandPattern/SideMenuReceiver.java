/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.SideMenu;


/**
 *
 * @author JaeHyuk
 * 클래스 역할 : Command패턴에서 리시버 역할
 */
public class SideMenuReceiver {
    public SideMenuReceiver() {
    }
    
    private SideMenu sideMenu;
    
    // 고른 사이드메뉴를 사이드메뉴시버에 담는 메서드
    public void addSide(SideMenu sideMenu) {
        this.sideMenu = sideMenu;
    }
    
    //선택되어 생성완료된 사이드메뉴를 가져오게 하는 메서드
    public SideMenu getSideMenu() {
        return sideMenu;
    }
}

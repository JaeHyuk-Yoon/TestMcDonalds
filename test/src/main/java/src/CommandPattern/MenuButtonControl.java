/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.CommandPattern;

import src.DecoratorPattern.Menu;

/**
 *
 * @author JaeHyuk
 * 클래스 역할 : Command패턴에서 Invoker 역할
 */
public class MenuButtonControl {
    private Command command;
    
    public MenuButtonControl() {
    }
    
    //실행할 명령객체를 설정하는 메서드
    public void setCommand(Command command) {
        this.command = command;
    }
    
    //해당 객체에 할당된 명령객체로 명령을 실행하도록하는 메서드
    public void addButtonWasPressed() {
        command.execute();
    }
}

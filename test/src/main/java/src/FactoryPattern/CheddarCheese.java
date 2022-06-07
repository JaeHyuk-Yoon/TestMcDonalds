/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class CheddarCheese implements Cheese{
    @Override
    public String getCheese() {
        return "치즈 : 체다치즈 사용";
    }
    public CheddarCheese() {
        //System.out.println("Cheddar Cheese");
    }
}

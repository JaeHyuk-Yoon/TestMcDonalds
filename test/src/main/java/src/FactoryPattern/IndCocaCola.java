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
public class IndCocaCola implements IndCola{
    String indname;
        
    public IndCocaCola() {
        //System.out.println("Ind Coca Cola");
        indname = "코카콜라";
    }
    
    @Override
    public String getIndCola() {
        return indname;
    }
}

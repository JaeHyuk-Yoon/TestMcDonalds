/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.IndCola;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class IndPepsiCola implements IndCola{
    
    String indname;
    
    public IndPepsiCola() {
        //System.out.println("Ind Pepsi Cola");
        indname = "펩시 콜라";
    }
    
    @Override
     public String getIndCola() {
        return indname;
    }
}

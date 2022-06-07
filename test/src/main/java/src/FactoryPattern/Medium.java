/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.FactoryPattern;

import src.FactoryPattern.IndBeefPatty;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class Medium implements IndBeefPatty{
    
    String indname;
    
    public Medium() {
        indname = "소고기 패티 굽기 : 미디움";
    }
    
    @Override
    public String getIndBeefPatty() {
        return indname;
    }
}

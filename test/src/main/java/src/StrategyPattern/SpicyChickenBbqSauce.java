/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.SelectSauce;

/**
 *
 * @author JaeHyuk
 */
public class SpicyChickenBbqSauce implements SelectSauce {
    public String getSauce() {
        return "매운 치킨 바베큐 소스";
    }    
}

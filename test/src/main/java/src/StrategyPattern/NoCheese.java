/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.CheeseWheather;

/**
 *
 * @author JaeHyuk
 */
public class NoCheese implements CheeseWheather {
    public String getCheeseWheather() {
        return "불필요";
    }
}

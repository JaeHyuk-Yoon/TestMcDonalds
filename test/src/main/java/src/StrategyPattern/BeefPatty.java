/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.StrategyPattern;

import src.StrategyPattern.SelectPatty;

/**
 *
 * @author JaeHyuk
 */
public class BeefPatty implements SelectPatty {
    public String getPatty() {
        return "비프 패티";
    }
}

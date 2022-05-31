/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author Minsu <jminsu084@gmail.com>
 */
public class GuilguVegetable implements Vegetable{
    @Override
    public String getVegetable() {
        return "Guilgu Vegetable";
    }
    public GuilguVegetable() {
        System.out.println("Guilgu Vegetable");
    }
}

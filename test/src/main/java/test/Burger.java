/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author JaeHyuk
 */
public abstract class Burger extends Menu{
    
    protected Bun bun;
    protected CheeseWheather cheeseWheather;
    protected SelectSauce selectSauce;
    protected SelectPatty selectPatty;
    protected SelectVegetable selectVegetable;
    protected boolean cheese;
    protected String sauce;
    protected String patty;
    protected String vegetable;
    
    public Burger() {
        
    }
    
    public abstract int cost();
    
    //public abstract String getDescription();
    
    public void setCheeseWheather(CheeseWheather scw) {
        cheeseWheather = scw;
    }
    public void setPatty(SelectPatty sp) {
        selectPatty = sp;
    }
    public void setSauce(SelectSauce ss) {
        selectSauce = ss;
    }
    public void setVegetable(SelectVegetable sv) {
        selectVegetable = sv;
    }
    
}

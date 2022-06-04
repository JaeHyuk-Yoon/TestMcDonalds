/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

/**
 *
 * @author heejin
 */
public class Menu {
    private String name;
    private int price;
    private String menu_type;

    public Menu() {
    }

    public Menu(String name, int price, String menu_type) {
        this.name = name;
        this.price = price;
        this.menu_type = menu_type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getMenu_type() {
        return menu_type;
    }

    public void setMenu_type(String menu_type) {
        this.menu_type = menu_type;
    }
    
}

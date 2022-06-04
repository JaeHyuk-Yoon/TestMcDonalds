/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author JaeHyuk
 */
public class Login {
    String id;
    String passwd;
    
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public Login() {
    }
    
    public int LoginConfirm(String id, String ps) {
        int num;
        
        if (id.equals("aaaa") && ps.equals("1111")) {
            num = 1;
        }
        else {
            num = 0;
        }
        
        return num;
    }
}

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
    int confirm;
    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public Login() {
        confirm = 0;
    }
    public void LoginInput() throws IOException {
        System.out.print("ID : ");
        id = br.readLine();
        System.out.print("PASSWORD : ");
        passwd = br.readLine();
        
        confirm = LoginConfirm(id, passwd);
         
        if(confirm == 1) {
            System.out.println("ㅎㅎ");
        }
    }
    
    public int LoginConfirm(String id, String ps) {
        int num;
        
        if (id.equals("aaaa") && ps.equals("1111")) {
            num = 1;
        }
        else {
            num = 0;
            System.out.println("ㄲㅈ");
        }
        
        return num;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author heejin
 */
public class OrderlistDAO {
    private Connection conn = null;
    private PreparedStatement pstmt= null;
    private ResultSet rs= null;
    String menu;
    String price;
    String branch;
    
    public OrderlistDAO(){
        try{
            String dbURL = "jdbc:mysql://localhost:3306/kiosk?serverTimezone=UTC";
            String dbID = "root";
            String dbPW = "1234";             
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL,dbID,dbPW);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void AddOrderList(String desc, String cost, String branch) {
        this.menu = desc;
        this.price  = cost;
        this.branch = branch;
        
        String SQL = "UPDATE stock SET qty = qty-1 WHERE name = ? AND branch = ?";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, ind);
            pstmt.setString(2, branch);
            pstmt.executeUpdate();
            
            
        } catch (SQLException ex) {
             Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
         } finally{
         if(rs!=null) try {
             rs.close();
         } catch (SQLException ex) {
             Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         if(pstmt!=null) try {
             pstmt.close();
         } catch (SQLException ex) {
             Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
         if(conn!=null) try {
             conn.close();
         } catch (SQLException ex) {
             Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        }
    }
}

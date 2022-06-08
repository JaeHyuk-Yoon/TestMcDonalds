/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;
/**
 *
 * @author heejin
 */
public class OrderlistDAO {
    private Connection conn = null;
    private PreparedStatement pstmt= null;
    private ResultSet rs= null;
    int orderNum;
    String menu;
    int price;
    String branch;
    String sDate;
    
    
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
    
    public int getOrderNum() {
        int num=0;
        String SQL = "SELECT MAX(ordernum) FROM orderlist";
        try{
            pstmt = conn.prepareStatement(SQL);
            rs = pstmt.executeQuery();
            if(rs.next()){
                num = rs.getInt(1)+1;
            }
            else{
                num = 1;
            }
        } catch (SQLException ex) {
             Logger.getLogger(StockDAO.class.getName()).log(Level.SEVERE, null, ex);
         }
        
        return num;
    }
    
    public java.sql.Date getDate() {
        //String sdate;
        
        Date today = new Date();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());
        
        return sqlDate;
    }
    
    public void AddOrderList(String desc, int totalcost, String branch) {
        this.menu = desc;
        this.price  = totalcost;
        this.branch = branch;
        
        orderNum = getOrderNum();
        //sDate = getDate();
        Date today = new Date();
        
        String SQL = "INSERT INTO orderlist VALUES(?,?,?,?,?,'x')";
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, orderNum);
            pstmt.setDate(2, new java.sql.Date(today.getTime()));
            pstmt.setString(3, menu);
            pstmt.setString(4, branch);
            pstmt.setInt(5, price);
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

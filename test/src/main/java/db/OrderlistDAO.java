/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.ArrayList;
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
    //주문들어왔을때 주문번호랑 브랜치로 주문내역 객체 가져갈수있음
    public Orderlist orderOn(int ordernum, String branch){
            Orderlist order = new Orderlist();
        try {
            String SQL = "SELECT * FROM orderlist WHERE ordernum = ? AND branch = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, ordernum);
            pstmt.setString(2, branch);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                order.setOrdernum(rs.getInt(1));
                order.setDate(rs.getDate(2));
                order.setMenu(rs.getString(3));
                order.setBranch(branch);
                order.setPrice(rs.getInt(5));
                order.setComplete(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            return order;
    }
}

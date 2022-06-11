/*
 * OrderlistDAO.java
 * - 주문내역관련 디비 값 관련 클래스
 */
package db;

import java.sql.*;

import java.util.ArrayList;
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

    //전체 주문 내역리스트 값을 읽는 메소드
    public ArrayList<Orderlist> getList(String branch){        
         String SQL = "SELECT * FROM orderlist WHERE branch = ? AND complete = ?";
         ArrayList<Orderlist> list = new ArrayList<>();
         try {
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, branch);
            pstmt.setString(2, "X");
            rs = pstmt.executeQuery();
            while (rs.next()) {
                Orderlist orderlist = new Orderlist();
                orderlist.setOrdernum(rs.getInt(1));
                orderlist.setDate(rs.getDate(2));
                orderlist.setMenu(rs.getString(3));
                orderlist.setBranch(branch);
                orderlist.setPrice(rs.getInt(5));
                orderlist.setComplete(rs.getString(6));
                list.add(orderlist);
            }
        } catch (SQLException ex) {
            Logger.getLogger(OrderlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    
    
    //주문들어왔을때 주문번호랑 브랜치로 주문내역 객체 가져가는 메소드
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
    
    //다음 주문번호를 받아오는 메소드
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
    
    //java.util.Date 타입의 현재 날짜를 sql.Date타입으로 변경하는 메소드
    public java.sql.Date getDate() {
        Date today = new Date();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());
        
        return sqlDate;
    }
    
    //주문 내역 추가하는 메소드
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
        }
    }
    
    //주문 제작완료상태로 변경하는 메소드
    public void completeOrder(String orderNum){
        try {
            String a = orderNum;
            String SQL = "UPDATE orderlist SET complete = 'O' WHERE ordernum = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, a);
            pstmt.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(OrderlistDAO.class.getName()).log(Level.SEVERE, null, ex);
        }            
    }
}

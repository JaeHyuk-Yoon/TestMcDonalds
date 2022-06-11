/*
 * SalesDAO.java
 * - 매출관련 디비 값관련 클래스
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
public class SalesDAO {
    private Connection conn = null;
    private PreparedStatement pstmt= null;
    private ResultSet rs= null;
    String sdate; int scost = 0; String sbranch;
    public Sales sales = new Sales();
    int cnt = 0;
    public SalesDAO(){
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
    
    //해당 브랜치의 날짜별 매출리스트를 가져오는 메소드
    public ArrayList<Sales> getList(String branch) throws SQLException{
        String SQL = "SELECT * FROM sales WHERE branch = ?";
        ArrayList<Sales> list = new ArrayList<>();
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, branch);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            Sales sales = new Sales();
            sales.setDate(rs.getDate(1));
            sales.setTotal(rs.getInt(2));
            sales.setBranch(rs.getString(3));
            list.add(sales);
        }
        return list;
    }
    
    //해당브랜치의 월별 매출리스트를 가져오는 메소드
    public ArrayList<MonthSales> getMonthList(String branch) throws SQLException{
        String SQL = "SELECT DATE_FORMAT(date,'%Y-%m') m, sum(total) s  FROM sales WHERE branch = ? GROUP BY m";
        ArrayList<MonthSales> list = new ArrayList<>();
        pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, branch);
        rs = pstmt.executeQuery();
        while (rs.next()) {
            MonthSales mSales = new MonthSales();
            mSales.setDate(rs.getString("m"));
            mSales.setTotal(Integer.parseInt(rs.getString("s")));
            mSales.setBranch(branch);
            list.add(mSales);
        }
        return list;
        
    }
    
    //해당날의 첫번째 판매라면 삽입하는 메소드
    public void insertSales(java.sql.Date date, int cost, String branch){
        try {
            System.out.println("di");
            String SQL = "INSERT INTO sales VALUES(?,?,?)";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setDate(1, date);
            System.out.println(date);
            pstmt.setInt(2, cost);
            pstmt.setString(3,branch);
            pstmt.executeUpdate();
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    //해당날의 첫번째 판매가 아니라면 매출액을 업데이트하는 메소드
    public void updateSales(java.sql.Date date, int cost, String branch){
        try {
            String SQL = "UPDATE sales SET total = ? WHERE date = ? AND branch = ?";
            System.out.println("aa");
            pstmt = conn.prepareStatement(SQL);
            pstmt.setInt(1, cost);
            pstmt.setDate(2, date);
            System.out.println(date);
            pstmt.setString(3,branch);
            pstmt.executeUpdate();
            //어
            if(pstmt!=null) pstmt.close();
            if(conn!=null) conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //해당 판매가 처음인지아닌지 구분하는 메소드
    public void isFirst(String date, String cost, String branch){
        sdate = date;
        sbranch = branch;
        try {
            java.sql.Date sqlDate = java.sql.Date.valueOf(date);
            System.out.println(sqlDate);
            String SQL = "SELECT total FROM sales WHERE date = ? AND branch = ?";
            pstmt = conn.prepareStatement(SQL);
            pstmt.setDate(1, sqlDate);
            pstmt.setString(2,branch);
            rs = pstmt.executeQuery();
            scost = Integer.parseInt(cost);
            if(rs.next()){
                scost=scost+rs.getInt("total");
                updateSales(sqlDate,scost,sbranch);
            }
            else{
                insertSales(sqlDate,scost,sbranch);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SalesDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

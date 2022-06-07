/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import javax.naming.NamingException;
/**
 *
 * @author heejin
 */
public class StockDAO {
     private Connection conn = null;
    private PreparedStatement pstmt= null;
    private ResultSet rs= null;
    public StockDAO(){
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
    public ArrayList<Stock> getList(String branch) throws NamingException, SQLException{
        String SQL = "SELECT * FROM stock WHERE branch = ?";
        ArrayList<Stock> list = new ArrayList<Stock>();
        try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, branch);
            rs = pstmt.executeQuery();
            while (rs.next()) {
			Stock stock = new Stock();
			stock.setName(rs.getString(1));
			stock.setQty(rs.getInt(2));
			stock.setBranch(branch);
			list.add(stock);
		}	
            return list;	
	} finally{
         if(rs!=null) rs.close();
         if(pstmt!=null) pstmt.close();
         if(conn!=null) conn.close();
        }	
  }
}


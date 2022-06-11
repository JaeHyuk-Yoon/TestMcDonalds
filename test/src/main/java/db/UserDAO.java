/*
 * UserDAO.java
 * - 사용자관련 디비 값 관련 클래스
 */
package db;

import java.sql.*;

/**
 *
 * @author heejin
 */

public class UserDAO {
    private Connection conn = null;
    private PreparedStatement pstmt= null;
    private ResultSet rs= null;
    
    public User user = new User();
    
    public UserDAO(){//mysql접속
        try{
            String dbURL = "jdbc:mysql://localhost:3306/kiosk?serverTimezone=UTC";
            String dbID = "root";
            String dbPW = "1234";             
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("연결");
            conn = DriverManager.getConnection(dbURL,dbID,dbPW);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    //로그인 메소드
    public int login(String id,String pw) throws SQLException{
        String SQL = "SELECT pw,branch,type FROM user WHERE id = ?";
         try{
            pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, id);
            rs = pstmt.executeQuery();
            if(rs.next()){
                if(rs.getString(1).equals(pw)){
                    user.setId(id);
                    user.setPw(pw);
                    user.setBranch(rs.getString(2));
                    user.setType(rs.getString(3));
                    if(rs.getString(3).equals("manager"))
                        return 1;//관리자 로그인 성공
                    else
                        return 2;//손님로그인 성공
                }
                else
                    return 0;//비번 틀림
            }
            return -1;//아이디 없음
        }catch(Exception e){
            e.printStackTrace();
        }finally{
             if(rs!=null) rs.close();
             if(pstmt!= null) pstmt.close();
             if (conn!=null) conn.close();
         }
         return -2;//데이터베이스오류
    }
}

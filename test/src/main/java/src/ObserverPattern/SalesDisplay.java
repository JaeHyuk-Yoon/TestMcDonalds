/*
SalesDisplay.java
- 주문알림을 받으면 주문정보 가져와 매출 값 더해주고 화면 업데이트
*/
package src.ObserverPattern;
import UI.ManagerMainPage;
import UI.SalesPage;
import db.Orderlist;
import db.OrderlistDAO;
import db.Sales;
import db.SalesDAO;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import src.ObserverPattern.DisplayElement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author heejin
 */
public class SalesDisplay implements Observer, DisplayElement {
  private int orderNum;
  private String branch;
  private ManagerMainPage mmp;
  private OrderData orderData;
  
  
  public SalesDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch,ManagerMainPage mmp) {
      //orderNum과 branch이용해서 해당 주문의 가격조회
      this.orderNum = orderNum;
      this.branch = branch;
      this.mmp = mmp;
      
      Orderlist order = order=(new OrderlistDAO()).orderOn(orderNum,branch);
      
      String cost = Integer.toString(order.getPrice());
      String orderDate = order.getDate().toString();

    //매출 더해주기-> 매출 값 업데이트
     new SalesDAO().isFirst(orderDate, cost, branch);
     
      display();
  }

  public void display() {
          //매출테이블보여주기
        mmp.showDayTable();
        mmp.showMonthTable();
          System.out.println("SalesDisplay");
  }
}

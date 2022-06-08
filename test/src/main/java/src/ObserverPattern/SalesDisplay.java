
package src.ObserverPattern;
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
  private OrderData orderData;
  
  public Orderlist order = new Orderlist();
  private ArrayList<Sales> salesList = new ArrayList<>();
  
  public SalesDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch) {
      //orderNum과 branch이용해서 해당 주문의 가격조회
      //String sc = "500";
      this.orderNum = orderNum;
      this.branch = branch;
      
      order=(new OrderlistDAO()).orderOn(orderNum,branch);
      
      String cost = Integer.toString(order.getPrice());
      String orderDate = order.getDate().toString();
     
//     Date date = new Date();
//     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//     String orderDate = sdf.format(date);
//매출 더해주기-> 매출 값 업데이트
     new SalesDAO().isFirst(orderDate, cost, branch);
     
     //월 값 더해주기(이건 걍 일값이용해서 추출)
     //이건 안해도 될듯? 이미 쿼리문에서 처리험
     
     
      display();
  }

  public void display() {
          //매출테이블보여주기
          SalesPage sg = new SalesPage(branch);
          sg.showDayTable();
          sg.showMonthTable();
  }


}


package src.ObserverPattern;
import db.SalesDAO;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import src.ObserverPattern.DisplayElement;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author heejin
 */
public class SalesDisplay implements Observer, DisplayElement {
  private int orderNum;
  private String branch;
  private OrderData orderData;
  
  public SalesDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch) {
      //orderNum과 branch이용해서 해당 주문의 가격조회
      //String sc = "500";
      
     //일 값 더해주기
     Date date = new Date();
     SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
     String orderDate = sdf.format(date);
     new SalesDAO().isFirst(orderDate, "10000", "SnG");
     
     //월 값 더해주기(이건 걍 일값이용해서 추출)
     
     
     
      display();
  }

  public void display() {
      //매출테이블보여주기
      System.out.println("SalesDisplay DISPLAY");
  }


}

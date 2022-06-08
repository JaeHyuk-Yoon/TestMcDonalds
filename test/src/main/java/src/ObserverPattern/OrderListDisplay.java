
package src.ObserverPattern;
import src.ObserverPattern.DisplayElement;
import src.ObserverPattern.OrderData;
/**
 *
 * @author heejin
 */
public class OrderListDisplay implements Observer, DisplayElement {
  private int orderNum;
  private String branch;
  private OrderData orderData;
  
  //private int numReadings = 0;
  
  public OrderListDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch) {
      
      //변수값 이용해서 DAO에서 값가져옴
          display();
  }
  public void display() {
      //orderlistdisplay 테이블 화면 다시 실행하도록
      System.out.println("OrderListDisplay DISPLAY");
  }
}

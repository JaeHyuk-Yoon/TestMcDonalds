
package src.ObserverPattern;
import UI.ManagerMainPage;
import src.ObserverPattern.DisplayElement;
import src.ObserverPattern.OrderData;
/**
 *
 * @author heejin
 */
public class StockDisplay implements Observer, DisplayElement {
  private String branch;
  private OrderData orderData;
  ManagerMainPage mmp;
  
  public StockDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch,ManagerMainPage mmp) {
      //브랜치만이용해서 그 브랜치의 재고 조회
      this.branch = branch;
      
      display();
  }

  public void display() {
      //StockDisplay 테이블 화면 다시 실행하도록
      System.out.println("StockDisplay DISPLAY");
  } 

}

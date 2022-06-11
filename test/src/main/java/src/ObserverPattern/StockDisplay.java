/*
StockDisplay.java
- 주문알림을 받으면 해당 브랜치의 재고 화면 업데이트
*/
package src.ObserverPattern;
import UI.ManagerMainPage;
/**
 *
 * @author heejin
 */
public class StockDisplay implements Observer, DisplayElement {
  private String branch;
  private OrderData orderData;
  private ManagerMainPage mmp;
  
  public StockDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch, ManagerMainPage mmp) {
    this.branch = branch;
    this.mmp=mmp;
    display();
  }

  public void display() {
      //StockDisplay 테이블 화면 다시 실행하도록
      mmp.showStockTable(branch);
      System.out.println("StockDisplay DISPLAY");
  } 

}

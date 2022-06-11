/*
OrderListDisplay.java
- 주문알림을 받으면 주문정보 가져와 화면 업데이트
*/
package src.ObserverPattern;
import UI.ManagerMainPage;
import db.Orderlist;
import db.OrderlistDAO;
import src.ObserverPattern.DisplayElement;
import src.ObserverPattern.OrderData;
/**
 *
 * @author heejin
 */
public class OrderListDisplay implements Observer, DisplayElement {
  private int orderNum;
  private String branch;
  private ManagerMainPage mmp;
  private OrderData orderData;
  private Orderlist order = new Orderlist();
  
  public OrderListDisplay(OrderData orderData) {
      this.orderData = orderData;
      orderData.registerObserver(this);
  }

  public void update(int orderNum, String branch, ManagerMainPage mmp) {
      this.orderNum = orderNum;
      this.branch = branch;
      this.mmp = mmp;
      //변수값 이용해서 DAO에서 값가져옴
      order=(new OrderlistDAO()).orderOn(orderNum,branch);
      display();
  }
  public void display() {
      //orderlistdisplay 테이블 화면 다시 실행하도록
    mmp.showListTable();
    //주문번호랑 주문내역 넘겨주기
    mmp.showNowDetailTable(orderNum, order.getMenu());
      System.out.println("OrderListDisplay DISPLAY");
  }
}

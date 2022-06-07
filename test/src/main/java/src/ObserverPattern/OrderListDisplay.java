
package src.ObserverPattern;
import src.ObserverPattern.DisplayElement;
import src.ObserverPattern.OrderData;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author heejin
 */
public class OrderListDisplay implements Observer, DisplayElement {
  private String menu;
  private int cost;
  private int numReadings = 0;
  public OrderListDisplay(Observable observable) {
      observable.addObserver(this);
  }

  public void update(Observable o, Object arg) {
      if(o instanceof OrderData){
          OrderData orderData = (OrderData)o;
          this.menu = orderData.getMenu();
          this.cost = orderData.getCost();
          numReadings++;
          display();
      }
  }

  public void display() {
      System.out.println("["+numReadings+"] 주문내역 : "+ menu +"  금액 : " +cost+"원");
  }

 

}


package src;
import src.DisplayElement;
import src.OrderData;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author heejin
 */
class SalesDisplay implements Observer, DisplayElement {
  private int cost;
  private int sales = 0;
  
  public SalesDisplay(Observable observable) {
       observable.addObserver(this);
  }

  public void update(Observable o, Object arg) {
      if(o instanceof OrderData){
          OrderData orderData = (OrderData)o;
          this.cost = orderData.getCost();
          sales +=cost;
          display();
      }
  }

  public void display() {
      System.out.println("현재 일 매출 : " + sales + "원");
  }


}

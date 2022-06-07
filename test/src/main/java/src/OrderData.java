
package src;

import java.util.Observable;
/**
 *
 * @author heejin
 */
class OrderData extends Observable {
    
  private String menu;
  private int cost;

    public OrderData() {
    }
  
  private void orderChanged() {
      setChanged();
      notifyObservers();
  }

  public void setOrder(String menu, int cost) {
      this.menu=menu;
      this.cost=cost;
      orderChanged();
  }
  public String getMenu() {
      return menu;
  }

  public int getCost() {
      return cost;
  }

}


package src.ObserverPattern;

import java.util.ArrayList;
/**
 *
 * @author heejin
 */
public class OrderData implements Subject {
    
  private int orderNum;
  private String branch;
  private ArrayList observers;
  
    public OrderData() {
        observers = new ArrayList();           
    }
    public void registerObserver(Observer o){
        observers.add(o);
    }
    
    public void removeObserver(Observer o){
        int i = observers.indexOf(o);
        if(i>=0){
            observers.remove(i);
        }
    }
    
    public void notifyObservers(){
        for(int i =0;i<observers.size();i++){
            Observer observer = (Observer) observers.get(i);
            observer.update(orderNum, branch);
        }
    }
    
    private void orderChanged() {
        notifyObservers();
    }
    
    public void setOrders(int orderNum, String branch){
        this.orderNum = orderNum;
        this.branch = branch;
        orderChanged();
    }
 
  public int getOrderNum() {
      return orderNum;
  }
  
  public String getbranch() {
      return branch;
  }
  
}

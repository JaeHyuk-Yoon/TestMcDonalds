/*
OrderData.java
- 옵저버 객체 등록및 제거, 주문정보 받고 알림
*/
package src.ObserverPattern;

import UI.ManagerMainPage;
import java.util.ArrayList;
/**
 *
 * @author heejin
 */
public class OrderData implements Subject {
    
  private int orderNum;
  private String branch;
  private  ArrayList observers;
  private  ManagerMainPage mmp;
  
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
            observer.update(orderNum, branch, mmp);
        }
    }
    
    private void orderChanged() {
        notifyObservers();
    }
    
    public void setOrders(int orderNum, String branch, ManagerMainPage mmp){
        this.orderNum = orderNum;
        this.branch = branch;
        this.mmp = mmp;
        orderChanged();
    }
 
  public int getOrderNum() {
      return orderNum;
  }
  
  public String getBranch() {
      return branch;
  }
  
}

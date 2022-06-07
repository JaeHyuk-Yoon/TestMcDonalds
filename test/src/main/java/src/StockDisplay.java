
package src;
import src.DisplayElement;
import src.OrderData;
import java.util.Observable;
import java.util.Observer;
/**
 *
 * @author heejin
 */
class StockDisplay implements Observer, DisplayElement {
  private String menu;
  //재고
  private int bunQty = 40;
  private int beefPattyQty = 20;
  private int chickenPattyQty = 20;
  private int chickenBbqSauceQty = 10;
  private int spicyChickenBbqSauceQty = 10;
  private int beefBbqSauceQty = 20;
  private int cheeseQty = 20;
  private int lettuceQty = 40;
  private int cheeseStickQty = 20;
  private int colaQty = 30;
  private int waterQty = 10;
  private int milkQty = 20;
  private int potatoQty = 30;
  
  public StockDisplay(Observable observable) {
      observable.addObserver(this);
  }

  public void update(Observable o, Object arg) {
      if(o instanceof OrderData){
          OrderData orderData = (OrderData)o;
          this.menu = orderData.getMenu();
          //메뉴에따라 수량 바뀌도록
          if(menu.equals("치즈버거세트")){
              bunQty--;
              beefPattyQty--;
              beefBbqSauceQty--;
              cheeseQty--;
              colaQty--;
              potatoQty--;
          }
          else if(menu.equals("치즈스틱")){
              cheeseStickQty--;
          }
          else if(menu.equals("매운치킨버거")){
              bunQty--;
              chickenPattyQty--;
              spicyChickenBbqSauceQty--;
              lettuceQty--;
          }
          display();
      }
  }

  public void display() {
      System.out.println("[재고]");
      System.out.println("빵 : " +bunQty);      
      System.out.println("패티");
      System.out.println("비프패티 : "+beefPattyQty+"  치킨패티 : "+chickenPattyQty);
      System.out.println("소스");
      System.out.println("치킨비비큐소스 : "+chickenBbqSauceQty+"  매운치킨비비큐소스 : "+spicyChickenBbqSauceQty+"  비프비비큐소스 : "+beefBbqSauceQty);
      System.out.println("토핑");
      System.out.println("치즈 : "+cheeseQty+"  양배추 : "+lettuceQty);
      System.out.println("사이드");
      System.out.println("치즈스틱 : "+ cheeseStickQty+"  감자 : "+potatoQty+"  콜라 : "+colaQty+"  물 : "+waterQty+"  우유 : "+milkQty);      
  } 

}

/*
Subject.java
- Subject 인터페이스
*/

package src.ObserverPattern;
/**
 *
 * @author heejin
 */
public interface Subject {

  void registerObserver(Observer o);  // 옵저버를 구독자로 등록
  void removeObserver(Observer o); // 옵저버의 구독을 해지
  void notifyObservers(); // 옵저버에 정보를 전달

}

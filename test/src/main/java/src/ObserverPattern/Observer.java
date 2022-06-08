/*
Observer.java
- observer 패턴의 요소인 Observer 객체에 해당
*/

package src.ObserverPattern;

import UI.ManagerMainPage;

/**
 *
 * @author heejin
 */

public interface Observer {
  void update(int orderNum, String branch, ManagerMainPage mmp) ;

}

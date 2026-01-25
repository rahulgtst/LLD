import java.util.*;

public class Main {
    public static void main(String[] args) {
      Observer t1 = new Trader();
      Observer t2 = new Trader();
      
      Stock s = new Stock();
      s.register(t1);
      s.setPrice(10);
      
      s.register(t2);
      s.setPrice(20);
  }
}

interface Observer<T> {
  void update(T value);
}

interface Subject {
  void register(Observer o);
  void remove(Observer o);
  void notifyObservers();
}

class Trader implements Observer<Integer> {
  @Override
  public void update(Integer value) {
    System.out.println("Stock price is changed to: " + value);
  }
}

class Stock implements Subject {
  private List<Observer> observers;
  private int price;
  
  Stock() {
    observers = new ArrayList<>();
  }
  
  void setPrice(int price) {
    this.price = price;
    notifyObservers();
  }
  
  @Override
  public void register(Observer o) {
    observers.add(o);
  }
  
  @Override
  public void remove(Observer o) {
    observers.remove(o);
  }
  
  @Override
  public void notifyObservers() {
    for(Observer ob: observers) {
      ob.update(price);
    }
  }
}

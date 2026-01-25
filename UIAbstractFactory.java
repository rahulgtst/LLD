import java.util.*;

public class Main {
  public static void main(String[] args) {
    WindowUIFactory window = new WindowUIFactory();
    Button btn = window.createButton();
    CheckBox cb = window.createCheckBox();
    btn.paint();
    cb.paint();
  }
}

interface Button {
  void paint();
}

interface CheckBox {
  void paint();
}

interface  UIFactory {
  Button createButton();
  CheckBox createCheckBox();
}

class WindowButton implements Button {
  @Override
  public void paint() {
    System.out.println("Window Button");
  }
}

class MacButton implements Button {
  @Override
  public void paint() {
    System.out.println("Mac Button");
  }
}

class WindowCheckBox implements CheckBox {
  @Override
  public void paint() {
    System.out.println("Window CheckBox");
  }
}

class MacCheckBox implements CheckBox {
  @Override
  public void paint() {
    System.out.println("Mac CheckBox");
  }
}

class WindowUIFactory implements UIFactory {
  @Override
  public Button createButton() {
    return new WindowButton();
  }
  
  @Override 
  public CheckBox createCheckBox() {
    return new WindowCheckBox();
  }
}

class MacUIFactory implements UIFactory {
  @Override
  public Button createButton() {
    return new MacButton();
  }
  
  @Override 
  public CheckBox createCheckBox() {
    return new MacCheckBox();
  }
}

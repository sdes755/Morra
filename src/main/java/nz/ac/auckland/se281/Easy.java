package nz.ac.auckland.se281;

public class Easy extends Gamemode implements Strategy {
  protected int finger;
  protected int sum;
  Strategy strategy;

  public int getFingers() {
    finger = strategy.getFingers();
    return finger;
  }

  public int getSum() {
    sum = strategy.getSum();
    return sum;
  }
}

package nz.ac.auckland.se281;

public class Context {
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getFingers() {
    return strategy.getFingers();
  }

  public int getSum() {
    return strategy.getSum();
  }
}

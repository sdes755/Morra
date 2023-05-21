package nz.ac.auckland.se281;

public class Context {
  // Initialsing the strategy
  private Strategy strategy;

  // Constructor to pass in the strategy
  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  // Setting the strategy for runtime switching
  public void setContext(Strategy strategy) {
    this.strategy = strategy;
  }

  // Getting the fingers from the strategy
  public int getFingers() {
    return strategy.getFingers();
  }

  // Getting the sum from the strategy
  public int getSum() {
    return strategy.getSum();
  }
}

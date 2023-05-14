package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Context {
  private Strategy strategy;

  public Context(Strategy strategy) {
    this.strategy = strategy;
  }

  public int getFingers() {
    return strategy.getFingers();
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    return strategy.getSum(rank,userF) ;
  }
}

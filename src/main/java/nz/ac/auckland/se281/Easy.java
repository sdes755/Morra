package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Easy extends Gamemode implements Strategy {
  protected int finger;
  protected int sum;
  Strategy strategy;
  Context context = new Context(new Random());

  public int getFingers() {
    finger = context.getFingers();
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    sum = context.getSum(rank, userF);
    return sum;
  }
}

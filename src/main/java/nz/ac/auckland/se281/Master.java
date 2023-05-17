package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Master extends Gamemode implements Strategy {

  protected int finger;
  protected int sum;
  protected int rank;
  protected ArrayList<Integer> userF;

  private Context context;

  public Master(ArrayList<Integer> userF, int rank) {
    this.userF = userF;
    this.rank = rank;
    this.context = new Context(new RAT(userF, rank));
  }

  public int getFingers() {
    finger = context.getFingers();
    return finger;
  }

  public int getSum() {
    sum = context.getSum();
    return sum;
  }
}

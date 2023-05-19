package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Medium extends Gamemode {
  protected int finger;
  protected int sum;
  protected int rank;
  protected ArrayList<Integer> userF;
  private Context context;

  public Medium(ArrayList<Integer> userF, int rank) {
    this.userF = userF;
    this.rank = rank;
    if ((rank - 1) <= 3) {
      this.context = new Context(new Random());
    } else {
      this.context = new Context(new Average(userF));
    }
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

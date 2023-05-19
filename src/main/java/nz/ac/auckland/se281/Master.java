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
    if ((rank - 1) <= 3) {
      this.context = new Context(new Random());
    } else if ((rank - 1) % 2 == 0) {
      this.context = new Context(new Average(userF));
    } else {
      this.context = new Context(new Top(userF));
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

package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Hard extends Gamemode implements Strategy {
  protected int finger;
  protected int sum;
  protected ArrayList<Integer> userF;
  protected int rank;

  private Context context;

  public Hard(ArrayList<Integer> userF, int rank) {
    this.userF = userF;
    this.rank = rank;
    if ((rank - 1) <= 3) {
      this.context = new Context(new Random());
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

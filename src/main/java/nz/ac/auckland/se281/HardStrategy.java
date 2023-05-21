package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardStrategy extends Gamemode {
  protected int finger;
  protected int sum;
  protected ArrayList<Integer> userF;
  protected int rank;

  private Context context;

  public HardStrategy(ArrayList<Integer> userF, int rank) {
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

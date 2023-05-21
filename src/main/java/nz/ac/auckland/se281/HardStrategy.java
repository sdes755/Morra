package nz.ac.auckland.se281;

import java.util.ArrayList;

public class HardStrategy extends Gamemode {
  // Intialising variables required for the calculation of AI's fingers and sum
  protected int finger;
  protected int sum;
  protected ArrayList<Integer> userF;
  protected int rank;
  // Intialising the strategy required for the gamemode
  private Context context;

  // Constructor to pass in the user fingers and rank
  public HardStrategy(ArrayList<Integer> userF, int rank) {
    this.userF = userF;
    this.rank = rank;
    // If condition to check if the rank is less than or equal to 3 and if so, the strategy will be
    // random
    // else the strategy will be top
    if ((rank - 1) <= 3) {
      this.context = new Context(new Random());
    } else {
      this.context = new Context(new Top(userF));
    }
  }

  // Calculating the AI fingers using the strategy and returning it
  public int getFingers() {
    finger = context.getFingers();
    return finger;
  }

  // Calculating the AI sum using the strategy and returning it
  public int getSum() {
    sum = context.getSum();
    return sum;
  }
}

package nz.ac.auckland.se281;

public class EasyStrategy extends Gamemode {
  // Intialising variables required for the calculation of AI's fingers and sum
  protected int finger;
  protected int sum;
  // Creating an instance of the strategy required for the gamemode
  private Context context = new Context(new Random());

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

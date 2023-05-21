package nz.ac.auckland.se281;

public class Easy extends Gamemode {
  protected int finger;
  protected int sum;
  private Context context = new Context(new Random());

  public int getFingers() {
    finger = context.getFingers();
    return finger;
  }

  public int getSum() {
    sum = context.getSum();
    return sum;
  }
}

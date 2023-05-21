package nz.ac.auckland.se281;

public class Random implements Strategy {
  // EASY GAME MODE
  // Intialising variables required for the calculation of AI's fingers and sum
  private int finger;
  private int sum;
  private int minF = 1;
  private int maxF = 5;
  private int maxS;
  private int minS;

  // Calculating the AI fingers and sum and returning it
  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  // Calculating the AI sum and returning it
  @Override
  public int getSum() {
    sum = Utils.getRandomNumber(minS, maxS);
    return sum;
  }
}

package nz.ac.auckland.se281;

public class Random implements Strategy {
  private int finger;
  private int sum;
  private int minF = 1;
  private int maxF = 5;
  private int maxS;
  private int minS;

  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  @Override
  public int getSum() {
    sum = Utils.getRandomNumber(minS, maxS);
    return sum;
  }
}

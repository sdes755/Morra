package nz.ac.auckland.se281;

public class Random implements Strategy {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int maxS;
  int minS;

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum() {
    sum = Utils.getRandomNumber(minS, maxS);
    return sum;
  }
}

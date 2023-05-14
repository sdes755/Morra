package nz.ac.auckland.se281;

public class Random implements Strategy {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    return finger;
  }

  public int getSum() {
    sum = Utils.getRandomNumber(getFingers() + 1, getFingers() + 5);
    return sum;
  }
}

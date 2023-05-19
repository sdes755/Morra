package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Average implements Strategy {
  private int finger;
  private int sum;
  private int minF = 1;
  private int maxF = 5;
  private float count = 0;
  private float sumF = 0;
  private ArrayList<Integer> userF;

  public Average(ArrayList<Integer> userF) {
    this.userF = userF;
  }

  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    return finger;
  }

  @Override
  public int getSum() {

    for (int i = 0; i < userF.size() - 1; i++) {
      sumF = sumF + userF.get(i);
      count++;
    }
    float average = sumF / count;
    int avg = Math.round(average);
    sum = avg + finger;
    return sum;
  }
}

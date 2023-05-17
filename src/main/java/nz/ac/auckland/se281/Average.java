package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Average implements Strategy {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;
  float count = 0;
  float sumF = 0;
  int rank;
  ArrayList<Integer> userF;

  public Average(ArrayList<Integer> userF, int rank) {
    this.userF = userF;
    this.rank = rank;
  }

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  @Override
  public int getSum() {

    if ((rank - 1) < 4) {
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    } else {
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
}

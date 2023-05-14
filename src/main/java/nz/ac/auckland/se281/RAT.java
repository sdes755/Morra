package nz.ac.auckland.se281;

import java.util.ArrayList;

public class RAT implements Strategy {

  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;
  float sumF = 0;
  float count = 0;

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    int fingers = finger;
    if ((rank - 1) < 4) {
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    } else {
      if (((rank - 1) % 2 == 0) == true) {

        for (int i = 0; i < userF.size() - 1; i++) {
          sumF = sumF + userF.get(i);
          count++;
        }
        float average = sumF / count;
        int avg = Math.round(average);
        sum = avg + finger;
        return sum;
      } else {
        int element = userF.get(0);
        int maxCount = 0;
        for (int i = 0; i < userF.size() - 1; i++) {
          int currentF = userF.get(i);
          int currentCount = 1;
          for (int j = i + 1; j < userF.size() - 1; j++) {
            if (userF.get(j) == currentF) {
              currentCount++;
            }
          }
          if (currentCount > maxCount) {
            maxCount = currentCount;
            element = currentF;
          }
        }
        sum = element + fingers;
        return sum;
      }
    }
  }
}

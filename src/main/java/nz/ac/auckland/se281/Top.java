package nz.ac.auckland.se281;

import java.util.ArrayList;
import java.util.Collections;

public class Top implements Strategy {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;
  int mostFrequent;
  int mostFrequentCount;
  int currentCount = 0;

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    Collections.sort(userF);
    System.out.println(userF);
    int currentF = userF.get(0);
    if ((rank - 1) < 4) {
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    } else {
      for (int i = 1; i < userF.size() - 1; i++) {
        int element = userF.get(i);
        if (element == currentF) {
          currentCount++;
        } else {
          if (currentCount > mostFrequentCount) {
            mostFrequentCount = currentCount;
            mostFrequent = currentF;
          }
          currentF = element;
          currentCount = 1;
        }
        if (currentCount > mostFrequentCount) {
          mostFrequent = currentF;
        }
      }

      System.out.println(mostFrequent);
      sum = mostFrequent + finger;
      return sum;
    }
  }
}

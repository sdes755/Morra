package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Top implements Strategy {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;
  ArrayList<Integer> userF;

  public Top(ArrayList<Integer> userF) {
    this.userF = userF;
  }

  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  @Override
  public int getSum() {
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
    sum = element + finger;
    return sum;
  }
}

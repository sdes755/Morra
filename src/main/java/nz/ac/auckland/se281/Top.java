package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Top {
  int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;
  int count = 0;

  private ArrayList<Integer> mostFrequent = new ArrayList<Integer>();

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    if ((rank - 1) < 4) {
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    } else {

      for (int i = 0; i < userF.size(); i++) {
        for (int j = 0; j < userF.size(); j++) {
          if (userF.get(i) == userF.get(j)) {
            count++;
          }
        }
        mostFrequent.add(count);
      }

      return sum;
    }
  }
}

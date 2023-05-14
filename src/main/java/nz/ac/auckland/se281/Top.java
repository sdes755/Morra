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
  int count = 0;

  private ArrayList<Integer> mostFrequent = new ArrayList<Integer>();

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    System.out.println("I am here");
    if ((rank - 1) < 4) {
      System.out.println("I am here");
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    } else {
      for (int i = 0; i < userF.size(); i++) {
        int count = Collections.frequency(userF, userF.get(i));
        mostFrequent.add(count);
      }
      System.out.println(mostFrequent);
      return sum;
    }
  }
}

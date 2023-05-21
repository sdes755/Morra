package nz.ac.auckland.se281;

import java.util.ArrayList;

public class Average implements Strategy {
  // MEDIUM GAME MODE
  // Initialising values required for the calculation of AI's fingers and sum
  private int finger;
  private int sum;
  private int minF = 1;
  private int maxF = 5;
  private float count = 0;
  private float sumF = 0;
  private ArrayList<Integer> userF;

  // Using a constructor to pass in the past user fingers for calculation
  public Average(ArrayList<Integer> userF) {
    this.userF = userF;
  }

  // Using the Utils Random method to get the fingers and returning it
  @Override
  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    return finger;
  }

  // Calculating the AI sum using the AI finger previously calculated and the average of the user
  // fingers
  // And returning it
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

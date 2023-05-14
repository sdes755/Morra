package nz.ac.auckland.se281;

public class RAT implements Strategy{

    int finger;
  int sum;
  int minF = 1;
  int maxF = 5;
  int minS;
  int maxS;

  public int getFingers() {
    finger = Utils.getRandomNumber(minF, maxF);
    maxS = finger + 5;
    minS = finger + 1;
    return finger;
  }

  public int getSum(int rank, ArrayList<Integer> userF) {
    int element = userF.get(0);
    if ((rank - 1) < 4) {
      sum = Utils.getRandomNumber(minS, maxS);
      return sum;

    }

    
}

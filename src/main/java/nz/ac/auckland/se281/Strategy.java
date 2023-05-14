package nz.ac.auckland.se281;

import java.util.ArrayList;

public interface Strategy {
  public int getFingers();

  public int getSum(int rank, ArrayList<Integer> userF);
}

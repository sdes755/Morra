package nz.ac.auckland.se281;

import java.util.ArrayList;

public abstract class Gamemode {

  protected int fingers;
  protected int sum;

  public abstract int getFingers();

  public abstract int getSum(int rank, ArrayList<Integer> userF);
}

package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class GetModeFactory {
  public static Gamemode getGamemode(Difficulty difficulty, ArrayList<Integer> fingers, int rank) {

    if (difficulty == Difficulty.EASY) {
      return new Easy();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new Medium(fingers, rank);
    } else if (difficulty == Difficulty.HARD) {
      return new Hard(fingers, rank);
    } else if (difficulty == Difficulty.MASTER) {
      return new Master(fingers, rank);
    }
    return null;
  }
}

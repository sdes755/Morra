package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class GetModeFactory {
  // Creating a static method to select the gamemode difficulty and going into the correct class
  // where the correct strategy will be called
  // Passing in the difficulty, the user fingers and the rank
  public static Gamemode getGamemode(Difficulty difficulty, ArrayList<Integer> fingers, int rank) {
    // If condition to check which difficulty is selected and returning the correct strategy
    // Passing in the fingers and sum if required aswell
    if (difficulty == Difficulty.EASY) {
      return new EasyStrategy();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new Medium(fingers, rank);
    } else if (difficulty == Difficulty.HARD) {
      return new HardStrategy(fingers, rank);
    } else if (difficulty == Difficulty.MASTER) {
      return new Master(fingers, rank);
    }
    return null;
  }
}

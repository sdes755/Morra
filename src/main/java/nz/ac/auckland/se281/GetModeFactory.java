package nz.ac.auckland.se281;

import nz.ac.auckland.se281.Main.Difficulty;

public class GetModeFactory {
  public Gamemode getGamemode(Difficulty difficulty) {
    if (difficulty == Difficulty.EASY) {
      return new Easy();
    } else if (difficulty == Difficulty.MEDIUM) {
      return new Medium();
    } else if (difficulty == Difficulty.HARD) {
      // return new Hard();
    }
    return null;
  }
}

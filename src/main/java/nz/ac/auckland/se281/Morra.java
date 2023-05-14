package nz.ac.auckland.se281;

// import java.lang.reflect.Array;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  GetModeFactory getModeFactory = new GetModeFactory();
  private int rank = 1;
  private ArrayList<Integer> userF = new ArrayList<Integer>();
  private ArrayList<String> players = new ArrayList<String>();
  private Difficulty gameMode;
  private int toWin;
  private int humanW = 0;
  private int AIW = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    players.add(options[0]);
    rank = 1;
    userF.removeAll(userF);
    gameMode = difficulty;
    toWin = pointsToWin;
    humanW = 0;
    AIW = 0;
  }

  public void play() {
    if (players.size() != 0) {
      MessageCli.START_ROUND.printMessage(Integer.toString(rank));
      rank = rank + 1;
      getFS();
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void showStats() {
    if (players.size() != 0) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          players.get(players.size() - 1),
          Integer.toString(humanW),
          Integer.toString(toWin - humanW));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(AIW), Integer.toString(toWin - AIW));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void getFS() {

    MessageCli.ASK_INPUT.printMessage();
    String stats = Utils.scanner.nextLine();
    String[] statsArray = stats.split(" ");
    int fingers = Integer.parseInt(statsArray[0]);
    userF.add(fingers);
    int sum = Integer.parseInt(statsArray[1]);
    if (fingers < 0 || fingers > 5 || sum < 1 || sum > 10) {
      MessageCli.INVALID_INPUT.printMessage();
      getFS();
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage(
          players.get(players.size() - 1), Integer.toString(fingers), Integer.toString(sum));

      Gamemode gamemode = getModeFactory.getGamemode(gameMode);
      int AIF = gamemode.getFingers();
      int AIS = gamemode.getSum(rank, userF);
      int totalF = fingers + AIF;
      MessageCli.PRINT_INFO_HAND.printMessage(
          "Jarvis", Integer.toString(AIF), Integer.toString(AIS));
      if (AIS != totalF && sum != totalF) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      } else if (AIS == totalF && sum == totalF) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
      } else if (sum == totalF) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
        humanW++;
      } else if (AIS == totalF) {
        MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
        AIW++;
      }

      if (humanW == toWin) {
        MessageCli.END_GAME.printMessage(
            players.get(players.size() - 1), Integer.toString(rank - 1));
        players.removeAll(players);
        userF.removeAll(userF);
      } else if (AIW == toWin) {
        MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rank - 1));
        players.removeAll(players);
        userF.removeAll(userF);
      }
    }
  }
}

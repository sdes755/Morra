package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  private int rank = 1;
  private ArrayList<Integer> userF = new ArrayList<Integer>();
  private ArrayList<String> players = new ArrayList<String>();
  private Difficulty gameMode;
  private int toWin;
  private int humanW = 0;
  private int AI_WINS = 0;

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    players.add(options[0]);
    rank = 1;
    userF.removeAll(userF);
    gameMode = difficulty;
    toWin = pointsToWin;
    humanW = 0;
    AI_WINS = 0;
  }

  public void play() {
    if (players.size() != 0) {
      MessageCli.START_ROUND.printMessage(Integer.toString(rank));
      rank = rank + 1;
      getStats();
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
          "Jarvis", Integer.toString(AI_WINS), Integer.toString(toWin - AI_WINS));
    } else {
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  public void getStats() {

    MessageCli.ASK_INPUT.printMessage();
    String stats = Utils.scanner.nextLine();
    stats = stats.trim();
    if (stats.contains(" ") == false) {
      MessageCli.INVALID_INPUT.printMessage();
      getStats();
    } else {
      String[] statsArray = stats.split(" ");
      if (statsArray[0].contains(".")
          || statsArray[1].contains(".")
          || statsArray.length != 2
          || Utils.isInteger(statsArray[0]) == false
          || Utils.isInteger(statsArray[1]) == false) {
        MessageCli.INVALID_INPUT.printMessage();
        getStats();
      } else {
        int fingers = Integer.parseInt(statsArray[0]);
        userF.add(fingers);
        int sum = Integer.parseInt(statsArray[1]);

        if (fingers < 0 || fingers > 5 || sum < 1 || sum > 10) {
          MessageCli.INVALID_INPUT.printMessage();
          getStats();
        } else {
          MessageCli.PRINT_INFO_HAND.printMessage(
              players.get(players.size() - 1), Integer.toString(fingers), Integer.toString(sum));

          Gamemode gamemode = GetModeFactory.getGamemode(gameMode, userF, rank);
          int aiFingers = gamemode.getFingers();
          int aiSum = gamemode.getSum();
          int totalF = fingers + aiFingers;
          MessageCli.PRINT_INFO_HAND.printMessage(
              "Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));
          if (aiSum != totalF && sum != totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
          } else if (aiSum == totalF && sum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
          } else if (sum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
            humanW++;
          } else if (aiSum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
            AI_WINS++;
          }

          if (humanW == toWin) {
            MessageCli.END_GAME.printMessage(
                players.get(players.size() - 1), Integer.toString(rank - 1));
            players.removeAll(players);
            userF.removeAll(userF);
          } else if (AI_WINS == toWin) {
            MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rank - 1));
            players.removeAll(players);
            userF.removeAll(userF);
          }
        }
      }
    }
  }
}

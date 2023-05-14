package nz.ac.auckland.se281;

// import java.lang.reflect.Array;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {

  GetModeFactory getModeFactory = new GetModeFactory();

  private int rank = 1;
  private int size = 1;
  private int users = 1;
  // private ArrayList<Integer> fingers = new ArrayList<Integer>();
  private ArrayList<String> players = new ArrayList<String>();

  public Morra() {}

  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    players.add(options[0]);
  }

  public void play() {
    size = players.size();
    if (size != users) {
      users = players.size();
      rank = 1;
    } else {
    }
    MessageCli.START_ROUND.printMessage(Integer.toString(rank));
    getFS();
    rank = rank + 1;
  }

  public void showStats() {}

  public void getFS() {
    MessageCli.ASK_INPUT.printMessage();
    String stats = Utils.scanner.nextLine();
    String[] statsArray = stats.split(" ");
    int fingers = Integer.parseInt(statsArray[0]);
    int sum = Integer.parseInt(statsArray[1]);
    if (fingers < 0 || fingers > 5 || sum < 1 || sum > 10) {
      MessageCli.INVALID_INPUT.printMessage();
      getFS();
    } else {
      MessageCli.PRINT_INFO_HAND.printMessage(
          players.get(players.size() - 1), Integer.toString(fingers), Integer.toString(sum));
    }
    Gamemode gamemode = getModeFactory.getGamemode(Difficulty.EASY);
    int AIF = gamemode.getFingers();
    int AIS = gamemode.getSum();
    // System.out.println("AI fingers: " + AIF);
    // System.out.println("AI sum: " + AIS);
    int totalF = fingers + AIF;
    // System.out.println(totalF);
    MessageCli.PRINT_INFO_HAND.printMessage("Jarvis", Integer.toString(AIF), Integer.toString(AIS));
    if (AIS != totalF && sum != totalF) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
    } else if (sum == totalF) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
    } else if (AIS == totalF) {
      MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
    }
  }
}

package nz.ac.auckland.se281;

import java.util.ArrayList;
import nz.ac.auckland.se281.Main.Difficulty;

public class Morra {
  // Initialising fields and variables required for the game.
  // The round, the players, the difficulty, the number of points to win,
  // the number of wins for the human player and the number of wins for the AI player.
  private int rank = 1;
  private ArrayList<Integer> userF = new ArrayList<Integer>();
  private ArrayList<String> players = new ArrayList<String>();
  private Difficulty gameMode;
  private int toWin;
  private int humanW = 0;
  private int aiWins = 0;

  public Morra() {}

  // Starting a new game
  public void newGame(Difficulty difficulty, int pointsToWin, String[] options) {
    // Printing out the welcome message and setting variables to zero for a new user/game
    MessageCli.WELCOME_PLAYER.printMessage(options[0]);
    players.add(options[0]);
    rank = 1;
    userF.removeAll(userF);
    gameMode = difficulty;
    toWin = pointsToWin;
    humanW = 0;
    aiWins = 0;
  }

  // Running the game
  public void play() {
    // Printing out the start round message and incrementing the round number
    if (players.size() != 0) {
      MessageCli.START_ROUND.printMessage(Integer.toString(rank));
      rank = rank + 1;
      // Running the game and asking for the player inputs
      getStats();
    } else {
      // If the game has not been started, print out the message
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  // Printing out the stats of the game
  public void showStats() {
    // Printing out the stats of the user and the AI during the running of the game
    if (players.size() != 0) {
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          players.get(players.size() - 1),
          Integer.toString(humanW),
          Integer.toString(toWin - humanW));
      MessageCli.PRINT_PLAYER_WINS.printMessage(
          "Jarvis", Integer.toString(aiWins), Integer.toString(toWin - aiWins));
    } else {
      // Printing out the message if the game has not been started
      MessageCli.GAME_NOT_STARTED.printMessage();
    }
  }

  // Getting user fingers sum, Ai fingers sum, and checking who won the round
  public void getStats() {
    // Asking for the user input of the fingers and sum and checking for valid input.
    // If not valid, the method is run again, printing out the input message again.
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

        // If the input is valid, the game begins
      } else {
        // Storing the user finger and sum to variables
        int fingers = Integer.parseInt(statsArray[0]);
        userF.add(fingers);
        int sum = Integer.parseInt(statsArray[1]);
        // Checking for valid input of the fingers and sum
        if (fingers < 1 || fingers > 5 || sum < 1 || sum > 10) {
          MessageCli.INVALID_INPUT.printMessage();
          getStats();
        } else {
          // Printing out the user fingers and sum
          MessageCli.PRINT_INFO_HAND.printMessage(
              players.get(players.size() - 1), Integer.toString(fingers), Integer.toString(sum));
          // Getting the difficulty chosen for the game and running the game and
          // obtaining the AI finger and sum
          Gamemode gamemode = GetModeFactory.getGamemode(gameMode, userF, rank);
          int aiFingers = gamemode.getFingers();
          int aiSum = gamemode.getSum();
          // Getting the winning sum of the round
          int totalF = fingers + aiFingers;
          // Checking the outcome of the round and printing out the outcome and incrementing
          // the number of wins for the human player or the AI player
          MessageCli.PRINT_INFO_HAND.printMessage(
              "Jarvis", Integer.toString(aiFingers), Integer.toString(aiSum));
          if (aiSum != totalF && sum != totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
          } else if (aiSum == totalF && sum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("DRAW");
          } else if (sum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("HUMAN_WINS");
            humanW++;
            // The round is also a draw if both the Ai and User get the correct sum
          } else if (aiSum == totalF) {
            MessageCli.PRINT_OUTCOME_ROUND.printMessage("AI_WINS");
            aiWins++;
          }
          // If the the human/Ai reaches the required rounds, the game ends and the winner is
          // printed out
          // All the storing of fingers and sum is removed and the game is reset for the next user
          if (humanW == toWin) {
            MessageCli.END_GAME.printMessage(
                players.get(players.size() - 1), Integer.toString(rank - 1));
            players.removeAll(players);
            userF.removeAll(userF);
          } else if (aiWins == toWin) {
            MessageCli.END_GAME.printMessage("Jarvis", Integer.toString(rank - 1));
            players.removeAll(players);
            userF.removeAll(userF);
          }
        }
      }
    }
  }
}

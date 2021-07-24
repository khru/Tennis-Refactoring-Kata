import java.util.Map;

public class TennisGame1 implements TennisGame {

  private static final String ADVANTAGE_MESSAGE = "Advantage ";
  private static final String WINN_MESSAGE = "Win for ";
  private static final Map<Integer, String> DEFAULT_SCORES =
      Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");
  private int player1Score = 0;
  private int player2Score = 0;
  private String player1Name;
  private String player2Name;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1Name = player1Name;
    this.player2Name = player2Name;
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(player1Name)) {
      player1Score++;
      return;
    }

    player2Score++;
  }

  public String getScore() {
    if (player1Score == player2Score) {
      return getTiedScore(player1Score);
    }

    if (isGamePoint()) {
      return getGameScore();
    }

    return getDefaultScore();
  }

  private boolean isGamePoint() {
    return player1Score >= 4 || player2Score >= 4;
  }

  private String getDefaultScore() {
    return getScoreByPlayer(player1Score) + "-" + getScoreByPlayer(player2Score);
  }

  private String getScoreByPlayer(int playerScore) {
    return DEFAULT_SCORES.get(playerScore);
  }

  private String getGameScore() {

    String winningPlayer = getWinningPlayerName();
    int scoreDifference = getDifferenceScore();

    if (scoreDifference == 1) {
      return ADVANTAGE_MESSAGE + winningPlayer;
    }

    return WINN_MESSAGE + winningPlayer;
  }

  private int getDifferenceScore() {
    return Math.abs(player1Score - player2Score);
  }

  private String getWinningPlayerName() {
    return this.player1Score > this.player2Score ? this.player1Name : this.player2Name;
  }

  private static String getTiedScore(int player1Score) {
    switch (player1Score) {
      case 0:
        return "Love-All";
      case 1:
        return "Fifteen-All";
      case 2:
        return "Thirty-All";
      default:
        return "Deuce";
    }
  }
}

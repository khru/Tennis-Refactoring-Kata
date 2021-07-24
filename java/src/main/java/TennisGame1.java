import java.util.Map;

public class TennisGame1 implements TennisGame {

  private static final String ADVANTAGE_MESSAGE = "Advantage ";
  private static final String WINN_MESSAGE = "Win for ";
  private static final Map<Integer, String> DEFAULT_SCORES =
      Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");

  private final Player player1;
  private final Player player2;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1 = new Player(player1Name);
    this.player2 = new Player(player2Name);
  }

  public void wonPoint(String playerName) {
    if (playerName.equals(player1.name())) {
      this.player1.addPoint();
      return;
    }
    this.player2.addPoint();
  }

  public String getScore() {
    if (isDrawScore(player1, player2)) {
      return getTiedScore(player1.score());
    }

    if (isGamePoint()) {
      return getGameScore();
    }

    return getDefaultScore();
  }

  private boolean isDrawScore(Player player1, Player player2) {
    return player1.isDrawScore(player2);
  }

  private boolean isGamePoint() {
    return player1.score() >= 4 || player2.score() >= 4;
  }

  private String getDefaultScore() {
    return getScoreByPlayer(player1.score()) + "-" + getScoreByPlayer(player2.score());
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
    return Math.abs(player1.score() - player2.score());
  }

  private String getWinningPlayerName() {
    return this.player1.score() > this.player2.score() ? this.player1.name() : this.player2.name();
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

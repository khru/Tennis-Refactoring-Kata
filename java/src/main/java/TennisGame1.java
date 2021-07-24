
public class TennisGame1 implements TennisGame {

  private static final String ADVANTAGE_MESSAGE = "Advantage ";
  private static final String WINN_MESSAGE = "Win for ";
  private static final int ADVANTAGE_POINTS = 1;
  private final Player player1;
  private final Player player2;

  public TennisGame1(String player1Name, String player2Name) {
    this.player1 = new Player(player1Name);
    this.player2 = new Player(player2Name);
  }

  public void wonPoint(String playerName) {
    if (player1.equals(playerName)) {
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
    return player1.isGamePoint() || player2.isGamePoint();
  }

  private String getDefaultScore() {
    return player1.getDefaultScore() + "-" + player2.getDefaultScore();
  }

  private String getGameScore() {
    String winningPlayer = Player.getWinningPlayerName(player1, player2);

    if (Player.getDifferenceScore(player1, player2) == ADVANTAGE_POINTS) {
      return ADVANTAGE_MESSAGE + winningPlayer;
    }

    return WINN_MESSAGE + winningPlayer;
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

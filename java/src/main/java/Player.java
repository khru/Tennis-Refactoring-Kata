import java.util.Map;

public class Player {
  private final String name;
  private int score = 0;
  private static final int STARTING_GAME_POINT = 4;
  private static final Map<Integer, String> DEFAULT_SCORES =
      Map.of(0, "Love", 1, "Fifteen", 2, "Thirty", 3, "Forty");

  Player(String name) {
    this.name = name;
  }

  public void addPoint() {
    this.score++;
  }

  public boolean isGamePoint() {
    return this.score >= STARTING_GAME_POINT;
  }

  public String getDefaultScore() {
    return DEFAULT_SCORES.get(score);
  }

  public String getTiedScore() {
    switch (score) {
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

  public static String getWinningPlayerName(Player player1, Player player2) {
    return player1.score > player2.score ? player1.name : player2.name;
  }

  public static boolean isDrawScore(Player player1, Player player2) {
    return player1.score == player2.score;
  }

  public static int getDifferenceScore(Player player1, Player player2) {
    return Math.abs(player1.score - player2.score);
  }

  public boolean equals(String name) {
    return this.name.equals(name);
  }
}

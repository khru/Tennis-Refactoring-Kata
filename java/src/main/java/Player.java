public class Player {
  private final String name;
  private int score = 0;

  Player(String name) {
    this.name = name;
  }

  public void addPoint() {
    this.score++;
  }

  public int score() {
    return this.score;
  }

  public String name() {
    return this.name;
  }

  public boolean isDrawScore(Player player) {
    return this.score == player.score;
  }
}

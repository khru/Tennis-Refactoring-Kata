public class Player {
  private final String name;
  private int score = 0;
  private static final int STARTING_GAME_POINT = 4;

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

  public boolean isGamePoint() {
    return this.score >= STARTING_GAME_POINT;
  }

  public boolean equals(String name) {
    return this.name.equals(name);
  }
}

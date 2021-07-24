public class TennisGame1 implements TennisGame {

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
    } else if (player1Score >= 4 || player2Score >= 4) {
      return getAdvantageOrWinner();
    }
    return getScoreByPlayer();
  }

  private String getScoreByPlayer() {
    String score = "";
    int tempScore;
    for (int i = 1; i < 3; i++) {
      if (i == 1) tempScore = player1Score;
      else {
        score += "-";
        tempScore = player2Score;
      }
      switch (tempScore) {
        case 0:
          score += "Love";
          break;
        case 1:
          score += "Fifteen";
          break;
        case 2:
          score += "Thirty";
          break;
        case 3:
          score += "Forty";
          break;
      }
    }
    return score;
  }

  private String getAdvantageOrWinner() {
    String score;
    String ADVANTAGE_MESSAGE = "Advantage ";
    String WINN_MESSAGE = "Win for ";
    int minusResult = getDifferentScore();
    if (minusResult == 1) score = ADVANTAGE_MESSAGE + "player1";
    else if (minusResult == -1) score = ADVANTAGE_MESSAGE + "player2";
    else if (minusResult >= 2) score = WINN_MESSAGE + "player1";
    else score = WINN_MESSAGE + "player2";
    return score;
  }

  private int getDifferentScore() {
    return player1Score - player2Score;
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

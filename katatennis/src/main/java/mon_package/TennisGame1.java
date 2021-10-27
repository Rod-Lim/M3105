package mon_package;


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
        if (playerName.equals(this.player1Name))
            this.player1Score += 1;
        else
            this.player2Score += 1;
    }

    public String getScore() {
        if (player1Score == player2Score) return getScoreForEgality();
        if (player1Score >=4 || player2Score >=4) return getScoreForAdvantageAndWin();
        return getScoreStandard();
    }

    private String getScoreStandard() {
        String score;
        String[] possibleScores = {"Love","Fifteen","Thirty","Forty"};
        score = possibleScores[player1Score] + "-" + possibleScores[player2Score];
        return score;
    }

    private String getScoreForAdvantageAndWin() {
        String score;
        int minusResult = player1Score - player2Score;
        if (minusResult==1) score ="Advantage " + this.player1Name;
        else if (minusResult ==-1) score ="Advantage " + this.player2Name;
        else if (minusResult>=2) score = "Win for " + this.player1Name;
        else score ="Win for " + this.player2Name;
        return score;
    }

    private String getScoreForEgality() {
        if (player1Score>=3) return "Deuce";
        String[] possibleScores = {"Love-All","Fifteen-All","Thirty-All"};
        return possibleScores[player1Score];
    }
}
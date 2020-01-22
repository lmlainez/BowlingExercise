package org.luis;


public class BowlingGameRound {



    private int score = 0;


    private boolean isStrike;
    private boolean isHalfStrike;

    public boolean isStrike() {
        return isStrike;
    }

    public void setStrike(boolean strike) {
        isStrike = strike;
    }

    public boolean isHalfStrike() {
        return isHalfStrike;
    }

    public void setHalfStrike(boolean halfStrike) {
        isHalfStrike = halfStrike;

    }

    public int getScore() {
        return score;
    }


    public void addScore(int score) {
        this.score += score;
    }

}

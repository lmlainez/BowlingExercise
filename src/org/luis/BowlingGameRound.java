package org.luis;


public class BowlingGameRound {

    public static int ALL_PINS = 10;

    private int firstRoll = 0;
    private int secondRoll = 0;
    private boolean isStrike;
    private boolean isHalfStrike;

    public boolean isStrike() {
        return firstRoll == ALL_PINS;
    }

    public boolean isHalfStrike() {
        return (firstRoll+secondRoll) == ALL_PINS;
    }

    public void setHalfStrike(boolean halfStrike) {
        isHalfStrike = halfStrike;

    }

    public int getFirstRoll() {
        return firstRoll;
    }

    public void setFirstRoll(int firstRoll) {
        this.firstRoll = firstRoll;
    }

    public int getSecondRoll() {
        return secondRoll;
    }

    public void setSecondRoll(int secondRoll) {
        this.secondRoll = secondRoll;
    }

}

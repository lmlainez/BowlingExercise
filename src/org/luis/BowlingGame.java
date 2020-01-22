package org.luis;


import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static int ALL_PINS = 10;
    private static int MAX_ROUNDS = 10;

    private List<BowlingGameRound> gameRounds = new ArrayList(10);
    private int roundNumber = 0 ;
    private int numberOfPinsThrownInThisRound = 0;

    public void roll(int noPins){

        if(isGameOver()){
            throw new InvalidGameMoveException("The game is over, you can't roll anymore");
        }

        if(noPins > ALL_PINS){
            throw new InvalidGameMoveException("You can't throw more pins than the maximum");
        }

        BowlingGameRound currentRound;
        boolean rollCountsDouble = false;
        BowlingGameRound previousRound = getPreviousRound();
        numberOfPinsThrownInThisRound += noPins;

        //First time someone throws the ball in this round
        if(gameRounds.size() <= roundNumber){

            if(previousRound != null){
                rollCountsDouble = previousRound.isStrike() || previousRound.isHalfStrike();
            }

            currentRound =  new BowlingGameRound();
            gameRounds.add(currentRound);

            if(numberOfPinsThrownInThisRound == ALL_PINS) {
                currentRound.setStrike(true);
                roundNumber++;
            }
        }else{
            //Second time someone throws the ball in this round
            currentRound = gameRounds.get(roundNumber);

            if(numberOfPinsThrownInThisRound == ALL_PINS) {
                currentRound.setHalfStrike(true);
            }

            if(previousRound != null){
                rollCountsDouble = previousRound.isStrike() ;
            }

            roundNumber++;
            numberOfPinsThrownInThisRound = 0;

        }
        if(rollCountsDouble){
            previousRound.addScore(noPins);
        }
        currentRound.addScore(noPins);

    }

    public boolean isGameOver(){
        return roundNumber>=MAX_ROUNDS;
    }

    private BowlingGameRound getPreviousRound(){
        if(roundNumber <= 0){
            return null;
        }
        return gameRounds.get(roundNumber-1);
    }



    public int score(){
        int score=0;
        for(BowlingGameRound round : gameRounds){
            score += round.getScore();
        }
        return score;
    }
}

package org.luis;


import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    private static int MAX_ROUNDS = 10;

    private List<BowlingGameRound> gameRounds = new ArrayList(10);
    private int roundNumber = 0 ;
    private int numberOfPinsThrownInThisRound = 0;

    public void roll(int noPins){

        if(isGameOver()){
            throw new InvalidGameMoveException("The game is over, you can't roll anymore");
        }

        if(noPins > BowlingGameRound.ALL_PINS){
            throw new InvalidGameMoveException("You can't throw more pins than the maximum");
        }

        BowlingGameRound currentRound;
        numberOfPinsThrownInThisRound += noPins;

        //First time someone throws the ball in this round
        if(gameRounds.size() <= roundNumber){

            currentRound =  new BowlingGameRound();
            gameRounds.add(currentRound);

            if(numberOfPinsThrownInThisRound == BowlingGameRound.ALL_PINS) {
                nextRound();
            }

            currentRound.setFirstRoll(noPins);
        }else{
            //Second time someone throws the ball in this round
            currentRound = gameRounds.get(roundNumber);

            nextRound();
            currentRound.setSecondRoll(noPins);

        }

    }

    private void nextRound(){
        roundNumber++;
        numberOfPinsThrownInThisRound = 0;
    }

    public boolean isGameOver(){
        return roundNumber >= MAX_ROUNDS;
    }


    public int score(){

        int score=0;
        boolean strikeBonus = false;
        boolean halfStrikeBonus = false;
        for(int i=0 ; i < gameRounds.size(); i++){
            BowlingGameRound round = gameRounds.get(i);
            int additionalPoints=0;
            if(strikeBonus){
                additionalPoints = getStrikeAdditionalPoints(i);
                strikeBonus=false;
            }else if(halfStrikeBonus){
                additionalPoints = getSpareAdditionalPoints(i);
                halfStrikeBonus=false;
            }else{
                additionalPoints = 0;
                halfStrikeBonus = strikeBonus = false;
            }

            score += round.getFirstRoll() + round.getSecondRoll() + additionalPoints;
            
            if(round.isStrike()){
                strikeBonus = true;
            }else if(round.isHalfStrike()){
                halfStrikeBonus=true;
            }
        }

        return score;
    }

    private int getSpareAdditionalPoints(int roundNumber){
        return gameRounds.get(roundNumber).getFirstRoll();

    }

    private int getStrikeAdditionalPoints(int roundNumber){
        BowlingGameRound nextRound =  gameRounds.get(roundNumber);
        if (nextRound.isStrike()) {
            return nextRound.getFirstRoll() + gameRounds.get(roundNumber+1).getFirstRoll();
        }
        return nextRound.getFirstRoll() + nextRound.getSecondRoll();
    }


}

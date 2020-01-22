package org.luis;


import java.util.ArrayList;
import java.util.List;

public class BowlingGame {

    List<BowlingGameRound> gameRounds = new ArrayList(10);
    int throwNumber= 0 ;

    public void roll(int noPins){
        int roundNumber= throwNumber/2;
        BowlingGameRound currentRound;
        if(gameRounds.size() <= roundNumber){
            currentRound =  new BowlingGameRound();
            gameRounds.add(currentRound);
        }else{
            currentRound = gameRounds.get(roundNumber);
        }
        throwNumber ++;
        currentRound.addScore(noPins);

    }

    public int score(){
        int score=0;
        for(BowlingGameRound round : gameRounds){
            score += round.getScore();
        }
        return score;
    }
}

package org.luis;

import org.luis.BowlingGame;

public class Main {

    public static void main(String[] args) {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(4);
        bowlingGame.roll(5);

        //Round 2
        bowlingGame.roll(4);
        bowlingGame.roll(2);

        //Round 3 - Strike
        bowlingGame.roll(10);

        //Round 4 - Post Strike, counts double
        bowlingGame.roll(3);
        bowlingGame.roll(5);

        //Round 5 - Half Strike
        bowlingGame.roll(5);
        bowlingGame.roll(5);

        //Round 6 - After Half Strike - First counts double
        bowlingGame.roll(4);
        bowlingGame.roll(5);

        //Round 7
        bowlingGame.roll(1);
        bowlingGame.roll(2);

        //Round 8
        bowlingGame.roll(9);
        bowlingGame.roll(0);

        //Round 9
        bowlingGame.roll(0);
        bowlingGame.roll(8);

        //Round 10
        bowlingGame.roll(2);
        bowlingGame.roll(5);

        System.out.println("The total score is :" +bowlingGame.score() );
    }
}

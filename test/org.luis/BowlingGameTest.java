package org.luis;

import org.junit.Test;

import static org.junit.Assert.*;

//This test case has been designed using scores from here: https://www.bowlinggenius.com/
public class BowlingGameTest {


    @Test
    public void testNoStrikes() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        assertEquals(9,bowlingGame.score());

        //Round 2
        bowlingGame.roll(4);
        assertEquals(13,bowlingGame.score());
        bowlingGame.roll(2);
        assertEquals(15,bowlingGame.score());

        //Round 3 - Strike
        bowlingGame.roll(6);
        bowlingGame.roll(3);

        assertEquals(24,bowlingGame.score());

        //Round 4
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        assertEquals(32,bowlingGame.score());

        //Round 5
        bowlingGame.roll(5);
        bowlingGame.roll(1);
        assertEquals(38,bowlingGame.score());

        //Round 6
        bowlingGame.roll(4);
        bowlingGame.roll(2);
        assertEquals(44,bowlingGame.score());

        //Round 7
        bowlingGame.roll(1);
        bowlingGame.roll(2);
        assertEquals(47,bowlingGame.score());

        //Round 8
        bowlingGame.roll(9);
        bowlingGame.roll(0);
        assertEquals(56,bowlingGame.score());

        //Round 9
        bowlingGame.roll(0);
        bowlingGame.roll(8);
        assertEquals(64,bowlingGame.score());

        //Round 10
        bowlingGame.roll(2);
        bowlingGame.roll(5);
        assertEquals(71,bowlingGame.score());

        assertEquals(true,bowlingGame.isGameOver());


    }

    @Test
    public void bowlingGameTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        assertEquals(9,bowlingGame.score());

        //Round 2
        bowlingGame.roll(4);
        assertEquals(13,bowlingGame.score());
        bowlingGame.roll(2);
        assertEquals(15,bowlingGame.score());

        //Round 3 - Strike
        bowlingGame.roll(10);
        assertEquals(25,bowlingGame.score());

        //Round 4 - Post Strike, counts double
        bowlingGame.roll(3);
        bowlingGame.roll(5);
        assertEquals(41,bowlingGame.score());

        //Round 5 - Half Strike
        bowlingGame.roll(5);
        bowlingGame.roll(5);
        assertEquals(51,bowlingGame.score());

        //Round 6 - After Half Strike - First counts double
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        assertEquals(64,bowlingGame.score());

        //Round 7
        bowlingGame.roll(1);
        bowlingGame.roll(2);
        assertEquals(67,bowlingGame.score());

        //Round 8
        bowlingGame.roll(9);
        bowlingGame.roll(0);
        assertEquals(76,bowlingGame.score());

        //Round 9
        bowlingGame.roll(0);
        bowlingGame.roll(8);
        assertEquals(84,bowlingGame.score());

        //Round 10
        bowlingGame.roll(2);
        bowlingGame.roll(5);
        assertEquals(91,bowlingGame.score());

        assertEquals(true,bowlingGame.isGameOver());


    }

    @Test
    public void singleStrikeTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(10);

        //Round 2
        bowlingGame.roll(2);
        bowlingGame.roll(5);
        assertEquals(24,bowlingGame.score());

        bowlingGame.roll(3);
        bowlingGame.roll(3);
        assertEquals(30,bowlingGame.score());

        bowlingGame.roll(4);
        bowlingGame.roll(1);
        assertEquals(35,bowlingGame.score());

    }

    @Test
    public void doubleStrikeTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(10);

        //Round 2
        bowlingGame.roll(10);

        //Round 3
        bowlingGame.roll(2);
        bowlingGame.roll(5);

        bowlingGame.roll(6);
        bowlingGame.roll(3);

        assertEquals(55,bowlingGame.score());
    }

    @Test
    public void tripleStrikeTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();

        //Round 1
        bowlingGame.roll(10);

        //Round 2
        bowlingGame.roll(10);

        //Round 3
        bowlingGame.roll(10);

        //Round 4
        bowlingGame.roll(2);
        bowlingGame.roll(5);

        assertEquals(76,bowlingGame.score());

    }

    @Test(expected = InvalidGameMoveException.class)
    public void playerThrowingTooManyTimesTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();
        for( int i = 0; i< 10; i++){
            bowlingGame.roll(2);
            bowlingGame.roll(5);
        }
        assertEquals(true,bowlingGame.isGameOver());
        bowlingGame.roll(2);
    }

    @Test(expected = InvalidGameMoveException.class)
    public void personRollingTooManyPins() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();
        bowlingGame.roll(12);
    }


}
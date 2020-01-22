package org.luis;

import org.junit.Test;

import static org.junit.Assert.*;


public class BowlingGameTest {

    @Test
    public void bowlingGameTest() throws Exception {
        BowlingGame bowlingGame =  new BowlingGame();
        bowlingGame.roll(4);
        bowlingGame.roll(5);
        assertEquals(9,bowlingGame.score());
        bowlingGame.roll(4);
        assertEquals(13,bowlingGame.score());
        bowlingGame.roll(2);
        assertEquals(15,bowlingGame.score());

    }



}
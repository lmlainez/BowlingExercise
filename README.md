# BowlingExercise

To help with the club, we have engaged you to program a scoring system.

The features on the system are:

One player only
In each frame, the bowler has 2 tries to knock down all the pins
If in 2 tries, the bowler fails to knock down all the pins, their score is the sum of the number of pins they've knocked down in the 2 attempts
E.g, if a bowler rolls, 4,4

Their score is 8.

If in 2 tries, the bowler knocks down all the pins, it is a spare. The scoring of a spare is the sum of the number of pins knocked down plus the number of pins knocked down in the next bowl.
E.g, if a bowler rolls, 4,6 | 5, 0

Their score is 20. So that's (4 + 6 + 5) + (5 + 0)

If in one try, the bowler knocks down all the pins, it is a strike. The scoring of a strike is the sum of the number of pins knocked down plus the number of pins knocked down in the next two bowls.
E.g, if a bowler rolls, 10 | 5, 4

Their score is 28. So that's (10 + 5 + 4) + ( 5 + 4)

There are 10 pins in a frame
There are 10 frames in a match
Don't worry about validating the number of rolls in a frame
The interface should look like this (in Java);

bowlingGame.roll(noOfPins);
bowlingGame.score();


Notes: 
Given the previous points system, it differs from the traditional Bowling game, in which if someone makes a strike, the score in 10 + the SCORE of the next round.
In here, it is just the pins knocked down in the next 2 bowls.
This mismatch makes it impossible to get the 300 perfect score.

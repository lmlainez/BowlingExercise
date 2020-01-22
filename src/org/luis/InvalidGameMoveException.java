package org.luis;


public class InvalidGameMoveException extends RuntimeException{

    public InvalidGameMoveException(String message){
        super(message);
    }
}

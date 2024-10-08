package org.example.Exceptions;

public class CannotPlayWithoutPlayersException extends RuntimeException {
    public CannotPlayWithoutPlayersException(String message) {
        super(message);
    }
}

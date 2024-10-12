package org.example.Exceptions;

public class InvalidTournamentArgsException extends RuntimeException {
    public InvalidTournamentArgsException(String message) {
        super(message);
    }
}

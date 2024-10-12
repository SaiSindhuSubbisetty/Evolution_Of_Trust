package org.example.Entities;

import org.example.Exceptions.InvalidNumberOfPlayersException;
import org.example.Exceptions.InvalidNumberOfRoundsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TournamentTest {

    // Test for Negitive player count exception
    @Test
    public void testNegitiveNumberOfPlayers() {
        assertThrows(InvalidNumberOfPlayersException.class, () -> new Tournament(-1, 5, 5));
        assertThrows(InvalidNumberOfPlayersException.class, () -> new Tournament(5, -1, 5));
        assertThrows(InvalidNumberOfPlayersException.class, () -> new Tournament(5, 5, -1));
    }

    @Test
    public void testTournamentInitialization() {
        Tournament tournament = new Tournament(2, 2, 2);
        assertEquals(6, tournament.scores.size());
    }

    // Test for Negitive number of rounds exception
    @Test
    public void testNegitiveNumberOfRounds() {
        Tournament tournament = new Tournament(2, 2, 2);
        assertThrows(InvalidNumberOfRoundsException.class, () -> tournament.playTournament(0));
        assertThrows(InvalidNumberOfRoundsException.class, () -> tournament.playTournament(-1));
    }

    //Test for Zero rounds exception
    @Test
    public void testZeroRounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertThrows(InvalidNumberOfRoundsException.class, () -> {
            tournament.playTournament(0);
        });
    }

    //Test for positive rounds
    @Test
    public void testPositive1Round() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertDoesNotThrow(() -> {
            tournament.playTournament(1);
        });
    }

    @Test
    public void testPositive2Rounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertDoesNotThrow(() -> {
            tournament.playTournament(2);
        });
    }

    @Test
    public void testPositive10Rounds() {
        Tournament tournament = new Tournament(5, 5, 5);
        assertDoesNotThrow(() -> {
            tournament.playTournament(10);
        });
    }

    @Test
    public void testPlayTournamentTwice(){
        Tournament tournament = new Tournament(5, 5, 5);
        assertDoesNotThrow(() -> {
            tournament.playTournament(10);
        });
        assertDoesNotThrow(() -> {
            tournament.playTournament(10);
        });
    }

}

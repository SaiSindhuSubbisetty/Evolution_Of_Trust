package org.example.Entities;

import org.example.Exceptions.CannotPlayWithoutPlayersException;
import org.example.Exceptions.NoOfRoundsAreInvalidException;

import java.util.ArrayList;
import java.util.List;

public class EvolutionOfTrustMachine {
    private final Player player1;
    private final Player player2;

    public EvolutionOfTrustMachine(Player player1, Player player2) {
        if (player1 == null || player2 == null) {
            throw new CannotPlayWithoutPlayersException("Cannot play without players.");
        }
        this.player1 = player1;
        this.player2 = player2;
    }

    public void play(int numberOfRounds) {
        if (numberOfRounds <= 0) {
            throw new NoOfRoundsAreInvalidException("Number of rounds should be greater than 0.");
        }
        for (int i = 0; i < numberOfRounds; i++) {
            player1.playWith(player2);
        }
    }
}
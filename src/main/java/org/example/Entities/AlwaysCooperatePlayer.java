package org.example.Entities;

import org.example.Enums.Move;

public class AlwaysCooperatePlayer extends Player {

    public AlwaysCooperatePlayer() {
        super();
    }

    @Override
    protected Move nextMove() {
        return Move.COOPERATE;
    }
}
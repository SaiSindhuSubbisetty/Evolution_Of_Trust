package org.example.Entities;

import org.example.Enums.Move;

public class AlwaysCheatPlayer extends Player {

    public AlwaysCheatPlayer() {
        super();
    }

    @Override
    protected Move nextMove() {
        return Move.CHEAT;
    }
}
package org.example.Entities;

import org.example.Enums.Move;

public class CopycatPlayer extends Player {
    private Move lastOpponentMove;

    public CopycatPlayer() {
        super();
        this.lastOpponentMove = Move.CHEAT;
    }

    @Override
    public void playWith(Player otherPlayer) {
        Move copycatMove = this.nextMove();
        Move opponentMove = otherPlayer.nextMove();

        super.updateScore(copycatMove, opponentMove, otherPlayer);

        this.lastOpponentMove = opponentMove;
    }

    @Override
    protected void gain(){
        this.lastOpponentMove = Move.COOPERATE;
        super.gain();
    }

    @Override
    protected Move nextMove() {
        Move currentMove = this.lastOpponentMove;
        this.lastOpponentMove = Move.CHEAT;
        return currentMove;
    }
}
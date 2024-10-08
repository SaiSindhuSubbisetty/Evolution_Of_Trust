package org.example.Entities;

import org.example.Enums.Move;

public class DetectivePlayer extends Player {
    private int moveCount = 1;
    private boolean hasRetaliated = false;
    private Move previousOpponentMove;

    public DetectivePlayer() {
        super();
    }

    @Override
    public void playWith(Player otherPlayer) {
        Move playerMove = this.nextMove();
        Move opponentMove = otherPlayer.nextMove();

        super.updateScore(playerMove, opponentMove, otherPlayer);

        this.previousOpponentMove = opponentMove;
    }

    @Override
    protected void gain() {
        this.previousOpponentMove = Move.COOPERATE;
        super.gain();
    }

    @Override
    protected Move nextMove() {
        int currentMoveCount = this.moveCount;
        Move currentMove = this.previousOpponentMove;

        if (this.previousOpponentMove == Move.CHEAT) {
            hasRetaliated = true;
        }

        this.moveCount++;
        this.previousOpponentMove = Move.CHEAT;

        return switch (currentMoveCount) {
            case 1, 3, 4 -> Move.COOPERATE;
            case 2 -> Move.CHEAT;
            default -> hasRetaliated ? currentMove : Move.CHEAT;
        };
    }
}

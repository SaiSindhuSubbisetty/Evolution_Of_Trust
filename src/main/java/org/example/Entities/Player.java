package org.example.Entities;

import org.example.Enums.Move;

public abstract class Player implements Cloneable {
    private int score;

    public Player() {
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    protected void updateScore(Move playerMove, Move opponentMove, Player otherPlayer) {
        if (playerMove == Move.COOPERATE) {
            this.invest();
            otherPlayer.gain();
        }
        if (opponentMove == Move.COOPERATE) {
            this.gain();
            otherPlayer.invest();
        }
    }

    public void playWith(Player otherPlayer) {
        Move playerMove = this.nextMove();
        Move opponentMove = otherPlayer.nextMove();
        this.updateScore(playerMove, opponentMove, otherPlayer);
    }

    protected abstract Move nextMove();

    protected void gain() {
        this.score += 3;
    }

    private void invest() {
        this.score -= 1;
    }

    public void resetScore() {
        this.score = 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}

package org.example.Entities;

public class Detective extends Player {
    private int round;
    private boolean opponentCheated;

    public Detective() {
        super(true); // Start with cooperation
        this.round = 0;
        this.opponentCheated = false;
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        round++;
        if (round == 1) {
            return true;
        } else if (round == 2) {
            return false;
        } else if (round == 3 || round == 4) {
            return true;
        } else {
            if (otherPlayer.willCooperate) {
                return false;
            } else {
                opponentCheated = true;
                return otherPlayer.willCooperate;
            }
        }
    }
}

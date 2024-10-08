package org.example.Entities;

public abstract class Player {
    final Score score;
    protected boolean willCooperate;

    private static final int THREE_POINTS = 3;
    private static final int NEGATIVE_ONE_POINT = -1;

    public Player(boolean willCooperate) {
        this.score = new Score();
        this.willCooperate = willCooperate;
    }

    public void gain() {
        this.score.add(THREE_POINTS);
    }

    public void invest() {
        this.score.add(NEGATIVE_ONE_POINT);
    }

    public void transactWith(Player otherPlayer) {
        this.transact(otherPlayer);

        boolean currentPlayerWill = this.updateCooperation(otherPlayer);
        boolean otherPlayerWill = otherPlayer.updateCooperation(this);

        this.willCooperate = currentPlayerWill;
        otherPlayer.willCooperate = otherPlayerWill;
    }

    abstract boolean updateCooperation(Player otherPlayer);

    private void transact(Player otherPlayer) {
        if (this.willCooperate) {
            this.invest();
            otherPlayer.gain();
        }

        if (otherPlayer.willCooperate) {
            this.gain();
            otherPlayer.invest();
        }
    }
}
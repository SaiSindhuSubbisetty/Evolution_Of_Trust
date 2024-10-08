package org.example.Entities;

public class CopyCat extends Player {
    public CopyCat() {
        super(false);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return otherPlayer.willCooperate;
    }
}
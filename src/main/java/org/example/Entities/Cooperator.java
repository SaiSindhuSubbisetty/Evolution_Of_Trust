package org.example.Entities;

import org.example.Enums.Action;

public class Cooperator extends Player {
    public Cooperator() {
        super(true);
    }

    @Override
    boolean updateCooperation(Player otherPlayer) {
        return true;
    }
}

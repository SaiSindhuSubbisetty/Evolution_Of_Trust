package org.example.Entities;

import org.example.Enums.Action;
import org.example.Enums.Points;

public abstract class Player {
    private final Score score;

    public Player() {
        this.score = new Score();
    }

    public int getScore() {
        return this.score.points();
    }

    public void addCoins(Points points) {
        this.score.add(points.getValue());
    }

    public abstract Action chooseAction();
}

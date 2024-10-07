package org.example.Entities;

import org.example.Enums.Action;
import java.util.Random;

public class Player {
    private String name;
    private int coins;

    public Player(String name) {
        this.name = name;
        this.coins = 0;
    }

    public String getName() {
        return name;
    }

    public int getCoins() {
        return coins;
    }

    public void addCoins(int coins) {
        this.coins += coins;
    }

    public Action chooseAction() {
        Random random = new Random();
        return random.nextInt(2) == 0 ? Action.COOPERATE : Action.CHEAT;
    }

}

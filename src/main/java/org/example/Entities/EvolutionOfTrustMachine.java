package org.example.Entities;

import org.example.Enums.Action;

public class EvolutionOfTrustMachine {
    public void transact(Player player1, Action action1, Player player2, Action action2) {
        if (action1 == Action.COOPERATE && action2 == Action.COOPERATE) {
            player1.addCoins(2);
            player2.addCoins(2);
        } else if (action1 == Action.CHEAT && action2 == Action.CHEAT) {
            player1.addCoins(0);
            player2.addCoins(0);
        } else if (action1 == Action.CHEAT && action2 == Action.COOPERATE) {
            player1.addCoins(3);
            player2.addCoins(-1);
        } else if (action1 == Action.COOPERATE && action2 == Action.CHEAT) {
            player1.addCoins(-1);
            player2.addCoins(3);
        }
    }
}


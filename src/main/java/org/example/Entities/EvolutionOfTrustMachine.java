package org.example.Entities;

import org.example.Enums.Action;
import org.example.Enums.Points;

public class EvolutionOfTrustMachine {
    private static final int TWO_POINTS = 2;
    private static final int THREE_POINTS = 3;
    private static final int NEGATIVE_ONE_POINT = -1;

    public void transact(Player player1, Player player2) {
        Action action1 = player1.chooseAction();
        Action action2 = player2.chooseAction();

        if (action1 == Action.COOPERATE ) {
            player1.addCoins(Points.NEGATIVE_ONE_POINT);
            player2.addCoins(Points.THREE_POINTS);
        }
        if (action2 == Action.COOPERATE) {
            player1.addCoins(Points.THREE_POINTS);
            player2.addCoins(Points.NEGATIVE_ONE_POINT);
        }
    }

    public void playRounds(Player player1, Player player2, int rounds) {
        if(rounds<=0){
            throw new IllegalArgumentException("Rounds should be greater than 0");
        }
        for (int i = 0; i < rounds; i++) {
            transact(player1, player2);
        }
    }
}
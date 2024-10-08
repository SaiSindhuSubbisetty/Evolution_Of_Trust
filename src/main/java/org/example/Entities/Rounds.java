package org.example.Entities;

public class Rounds {
    private final Player player1;
    private final Player player2;

    public Rounds(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
    }

    public void transactFor(int numberOfRounds) {
        if(numberOfRounds <= 0) {
            throw new IllegalArgumentException("Number of rounds should be greater than 0.");
        }
        for (int i = 0; i < numberOfRounds; i++) {
            player1.transactWith(player2);
        }
    }
}
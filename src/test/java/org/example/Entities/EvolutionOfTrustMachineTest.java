package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EvolutionOfTrustMachineTest {

    @Test
    public void testPlayer1CheaterPlayer2Cooperator() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cheater();
        Player player2 = new Cooperator();

        machine.transact(player1, player2);

        assertEquals(3, player1.getScore(), "player1 should have 3 points");
        assertEquals(-1, player2.getScore(), "player2 should have -1 points");
    }
    @Test
    public void testPlayer1CooperatesPlayer2Cheats() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cooperator();
        Player player2 = new Cheater();

        machine.transact(player1, player2);

        assertEquals(-1, player1.getScore(), "player1 should have -1 points");
        assertEquals(3, player2.getScore(), "player2 should have 3 points");
    }

    @Test
    public void BothCooperatersShouldAddTwoPointsToEach() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cooperator();
        Player player2 = new Cooperator();

        machine.transact(player1, player2);

        assertEquals(2, player1.getScore(), "Both should have 2 points");
        assertEquals(2, player2.getScore(), "Both should have 2 points");
    }

    @Test
    public void tesBothCheatersShouldAddZeroPointsToEach() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cheater();
        Player player2 = new Cheater();

        machine.transact(player1, player2);

        assertEquals(0, player1.getScore(), "Both should have 0 points");
        assertEquals(0, player2.getScore(), "Both should have 0 points");
    }

    // Test cases for invalid rounds
    @Test
    void testPlayRoundsWithZeroRounds() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cheater();
        Player player2 = new Cooperator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            machine.playRounds(player1, player2, 0);
        });

        assertEquals("Rounds should be greater than 0", exception.getMessage());
    }

    @Test
    void testPlayRoundsWithNegativeRounds() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cheater();
        Player player2 = new Cooperator();

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            machine.playRounds(player1, player2, -1);
        });

        assertEquals("Rounds should be greater than 0", exception.getMessage());
    }

    //2nd story test case
    @Test
    public void testBothCheatersShouldHaveZeroPointsAfter5Rounds() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cheater();
        Player player2 = new Cheater();

        machine.playRounds(player1, player2, 5);

        assertEquals(0, player1.getScore(), "Both players should have 0 points after 5 rounds");
        assertEquals(0, player2.getScore(), "Both players should have 0 points after 5 rounds");
    }

    //3rd strory test case
    @Test
    public void testBothCooperatorsShouldHave10PointsAfter5Rounds() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player player1 = new Cooperator();
        Player player2 = new Cooperator();

        machine.playRounds(player1, player2, 5);

        assertEquals(10, player1.getScore(), "Both players should have 10 points after 5 rounds");
        assertEquals(10, player2.getScore(), "Both players should have 10 points after 5 rounds");
    }

    //4th story test case
    @Test
    void testCooperativeAndCheaterShouldPlayMultipleRoundsCorrectly() {
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();
        Player cheater = new Cheater();
        Player cooperator = new Cooperator();

        machine.playRounds(cheater, cooperator, 5);

        assertEquals(15, cheater.getScore(), "Cheater should have 15 points after 5 rounds");
        assertEquals(-5, cooperator.getScore(), "Cooperator should have -5 points after 5 rounds");
    }


}
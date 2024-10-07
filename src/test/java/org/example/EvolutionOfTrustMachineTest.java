package org.example;

import org.example.Entities.EvolutionOfTrustMachine;
import org.example.Entities.Player;
import org.example.Enums.Action;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
//test cases
class EvolutionOfTrustMachineTest {


    @Test
    public void expectsToCreateACheatPlayer() {
        assertDoesNotThrow(() -> new Player("Alice"));
    }

    @Test
    public void expectsToRandomlyChooseAction() {
        Player player = new Player("Alice");
        Action action = player.chooseAction();
        assertTrue(action == Action.CHEAT || action == Action.COOPERATE);
    }

    @Test
    public void expectsToCreateACooperatePlayer() {
        assertDoesNotThrow(() -> new Player("Alice"));
    }

    @Test
    public void testBothCooperate() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();

        machine.transact(player1, Action.COOPERATE, player2, Action.COOPERATE);

        assertEquals(2, player1.getCoins());
        assertEquals(2, player2.getCoins());
    }

    @Test
    public void testBothCheat() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();

        machine.transact(player1, Action.CHEAT, player2, Action.CHEAT);

        assertEquals(0, player1.getCoins());
        assertEquals(0, player2.getCoins());
    }

    @Test
    public void testPlayer1CheatsPlayer2Cooperates() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();

        machine.transact(player1, Action.CHEAT, player2, Action.COOPERATE);

        assertEquals(3, player1.getCoins());
        assertEquals(-1, player2.getCoins());
    }
    @Test
    public void testPlayer1CooperatesPlayer2Cheats() {
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");
        EvolutionOfTrustMachine machine = new EvolutionOfTrustMachine();

        machine.transact(player1, Action.COOPERATE, player2, Action.CHEAT);

        assertEquals(-1, player1.getCoins());
        assertEquals(3, player2.getCoins());
    }


}
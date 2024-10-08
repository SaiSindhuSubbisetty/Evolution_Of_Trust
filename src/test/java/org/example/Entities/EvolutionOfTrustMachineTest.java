package org.example.Entities;

import org.example.Entities.*;
import org.example.Exceptions.CannotPlayWithoutPlayersException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EvolutionOfTrustMachineTest {

    // Tests for EvolutionOfTrustMachine class
    @Test
    void testEvolutionOfTrustMachineInitialization() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        assertNotNull(EvolutionOfTrustMachine);
    }

    @Test
    void testExceptionWhenPlayerIsNull() {
        assertThrows(CannotPlayWithoutPlayersException.class, () -> new EvolutionOfTrustMachine(null, null));
    }

    // Tests for play(1) method
    @Test
    void testBothPlayersCooperate() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(1);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCooperatesSecondPlayerCheats() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(1);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCheatsSecondPlayerCooperates() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(1);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersAlwaysCheat() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(1);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    // Tests for AlwaysCheatPlayer vs others
    @Test
    void testBothPlayersAlwaysCheatsFiveRounds() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerAlwaysCooperatesFiveRounds() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(15, firstPlayer.getScore());
        assertEquals(-5, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerCopycatFiveRounds() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new CopycatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerDetectiveTenRounds() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new DetectivePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(9, firstPlayer.getScore());
        assertEquals(-3, secondPlayer.getScore());
    }

    // Tests for AlwaysCooperatePlayer vs others
    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerCheatsFiveRounds() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(-5, firstPlayer.getScore());
        assertEquals(15, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersAlwaysCooperatesFiveRounds() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(10, firstPlayer.getScore());
        assertEquals(10, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerCopycatFiveRounds() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new CopycatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(7, firstPlayer.getScore());
        assertEquals(11, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerDetectiveTenRounds() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new DetectivePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(27, secondPlayer.getScore());
    }

    // Tests for CopycatPlayer vs others
    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCheatsFiveRounds() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCooperatesFiveRounds() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(11, firstPlayer.getScore());
        assertEquals(7, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersCopycatsFiveRounds() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new CopycatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(5);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCopycatSecondPlayerDetectiveTenRounds() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new DetectivePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(19, firstPlayer.getScore());
        assertEquals(15, secondPlayer.getScore());
    }

    // Tests for DetectivePlayer vs others
    @Test
    void testFirstPlayerDetectiveSecondPlayerAlwaysCheatsTenRounds() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(-3, firstPlayer.getScore());
        assertEquals(9, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerDetectiveSecondPlayerAlwaysCooperatesTenRounds() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(27, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerDetectiveSecondPlayerCopycatTenRounds() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new CopycatPlayer();
        EvolutionOfTrustMachine evolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        evolutionOfTrustMachine.play(10);

        // Expected scores based on the new logic
        assertEquals(15, firstPlayer.getScore());
        assertEquals(19, secondPlayer.getScore());
    }

    @Test
    void testBothPlayersDetectivesTenRounds() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new DetectivePlayer();
        EvolutionOfTrustMachine EvolutionOfTrustMachine = new EvolutionOfTrustMachine(firstPlayer, secondPlayer);

        EvolutionOfTrustMachine.play(10);

        assertEquals(18, firstPlayer.getScore());
        assertEquals(18, secondPlayer.getScore());
    }
}
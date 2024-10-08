package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    // Tests for transactWith() method for AlwaysCheatPlayer with others
    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerCopycat() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCheatsSecondPlayerDetective() {
        Player firstPlayer = new AlwaysCheatPlayer();
        Player secondPlayer = new DetectivePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    // Tests for transactWith() method for AlwaysCooperatePlayer with others
    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerAlwaysCheats() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerCopycat() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerAlwaysCooperatesSecondPlayerDetective() {
        Player firstPlayer = new AlwaysCooperatePlayer();
        Player secondPlayer = new DetectivePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    // Tests for transactWith() method for CopycatPlayer with others
    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCheats() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCopycatSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerCopycatSecondPlayerDetective() {
        Player firstPlayer = new CopycatPlayer();
        Player secondPlayer = new DetectivePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(3, firstPlayer.getScore());
        assertEquals(-1, secondPlayer.getScore());
    }

    // Tests for transactWith() method for DetectivePlayer with others
    @Test
    void testFirstPlayerDetectiveSecondPlayerAlwaysCheats() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerDetectiveSecondPlayerAlwaysCooperates() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }

    @Test
    void testFirstPlayerDetectiveSecondPlayerCopycat() {
        Player firstPlayer = new DetectivePlayer();
        Player secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(-1, firstPlayer.getScore());
        assertEquals(3, secondPlayer.getScore());
    }
}
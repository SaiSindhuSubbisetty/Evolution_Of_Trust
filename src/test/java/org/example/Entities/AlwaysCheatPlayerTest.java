package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCheatPlayerTest {

    @Test
    void testAlwaysCheatPlayerShouldStartWithZeroCoins() {
        AlwaysCheatPlayer player = new AlwaysCheatPlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCheat() {
        AlwaysCheatPlayer firstPlayer = new AlwaysCheatPlayer();
        AlwaysCheatPlayer secondPlayer = new AlwaysCheatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }
}
package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlwaysCooperatePlayerTest {

    @Test
    void testAlwaysCooperatePlayerShouldStartWithZeroCoins() {
        AlwaysCooperatePlayer player = new AlwaysCooperatePlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCooperate() {
        AlwaysCooperatePlayer firstPlayer = new AlwaysCooperatePlayer();
        AlwaysCooperatePlayer secondPlayer = new AlwaysCooperatePlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(2, firstPlayer.getScore());
        assertEquals(2, secondPlayer.getScore());
    }
}
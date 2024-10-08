package org.example.Entities;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CopycatPlayerTest {

    @Test
    void testCopycatPlayerShouldStartWithZeroCoins() {
        CopycatPlayer player = new CopycatPlayer();
        int expected = 0;

        int actual = player.getScore();

        assertEquals(expected, actual);
    }

    // Tests for playWith() method
    @Test
    void testBothPlayersCopycats() {
        CopycatPlayer firstPlayer = new CopycatPlayer();
        CopycatPlayer secondPlayer = new CopycatPlayer();

        firstPlayer.playWith(secondPlayer);

        assertEquals(0, firstPlayer.getScore());
        assertEquals(0, secondPlayer.getScore());
    }

}
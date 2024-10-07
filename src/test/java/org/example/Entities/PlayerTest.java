package org.example.Entities;

import org.example.Enums.Action;
import org.example.Enums.Points;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testCheaterAlwaysCheats() {
        Player cheater = new Cheater();
        assertEquals(Action.CHEAT, cheater.chooseAction());
    }

    @Test
    void testCooperatorAlwaysCooperates() {
        Player cooperator = new Cooperator();
        assertEquals(Action.COOPERATE, cooperator.chooseAction());
    }

    @Test
    void testCheaterInitialScore() {
        Player cheater = new Cheater();
        assertEquals(0, cheater.getScore());
    }

    @Test
    void testCooperatorInitialScore() {
        Player cooperator = new Cooperator();
        assertEquals(0, cooperator.getScore());
    }

    @Test
    void testAddCoins() {
        Player player = new Cooperator();
        player.addCoins(Points.THREE_POINTS);
        assertEquals(3, player.getScore());
    }
}
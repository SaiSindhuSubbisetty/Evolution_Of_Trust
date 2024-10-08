package org.example.Entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void testCheaterAlwaysCheats() {
        Player cheater = new Cheater();
        assertFalse(cheater.updateCooperation(null), "Cheater should always cheat.");
    }

    @Test
    void testCooperatorAlwaysCooperates() {
        Player cooperator = new Cooperator();
        assertTrue(cooperator.updateCooperation(null), "Cooperator should always cooperate.");
    }

    @Test
    void testCheaterInitialScore() {
        Player cheater = new Cheater();
        assertEquals(0, cheater.score.points());
    }

    @Test
    void testCooperatorInitialScore() {
        Player cooperator = new Cooperator();
        assertEquals(0, cooperator.score.points());
    }

    @Test
    void testGainPoints() {
        Player player = new Cooperator();
        player.gain();
        assertEquals(3, player.score.points(), "Player should have gained 3 points.");
    }

    @Test
    void testInvestPoints() {
        Player player = new Cooperator();
        player.invest();
        assertEquals(-1, player.score.points(), "Player should have invested -1 point.");
    }
}

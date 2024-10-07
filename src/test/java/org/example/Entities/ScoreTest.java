package org.example.Entities;

import org.example.Exceptions.InvalidPointsException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {

    @Test
    void testInitialScore() {
        Score score = new Score();
        assertEquals(0, score.points());
    }

    @Test
    void testAddValidPoints() {
        Score score = new Score();

        score.add(2);

        assertEquals(2, score.points());
    }

    @Test
    void testAddInvalidPoints() {
        Score score = new Score();
        assertThrows(InvalidPointsException.class, () -> score.add(4));
    }

    @Test
    void testAddNegativePoints() {
        Score score = new Score();

        score.add(-1);

        assertEquals(-1, score.points());
    }
}
package org.example.Entities;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RoundsTest {

    @Test
    public void testPlayer1CheaterPlayer2Cooperator() {
        Player player1 = new Cheater();
        Player player2 = new Cooperator();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(1);

        assertEquals(3, player1.score.points());
        assertEquals(-1, player2.score.points());
    }

    @Test
    public void testPlayer1CooperatesPlayer2Cheats() {
        Player player1 = new Cooperator();
        Player player2 = new Cheater();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(1);

        assertEquals(-1, player1.score.points());
        assertEquals(3, player2.score.points());
    }

    @Test
    public void testBothCooperatorsShouldAddTwoPointsToEach() {
        Player player1 = new Cooperator();
        Player player2 = new Cooperator();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(1);

        assertEquals(2, player1.score.points());
        assertEquals(2, player2.score.points());
    }

    @Test
    public void testBothCheatersShouldAddZeroPointsToEach() {
        Player player1 = new Cheater();
        Player player2 = new Cheater();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(1);

        assertEquals(0, player1.score.points());
        assertEquals(0, player2.score.points());
    }

    @Test
    void testPlayRoundsWithZeroRounds() {
        Player player1 = new Cheater();
        Player player2 = new Cooperator();
        Rounds rounds = new Rounds(player1, player2);
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rounds.transactFor(0);
        });

        assertEquals("Number of rounds should be greater than 0.", exception.getMessage());
    }

    @Test
    void testPlayRoundsWithNegativeRounds() {
        Player player1 = new Cheater();
        Player player2 = new Cooperator();
        Rounds rounds = new Rounds(player1, player2);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            rounds.transactFor(-1);
        });

        assertEquals("Number of rounds should be greater than 0.", exception.getMessage());
    }

    @Test
    public void testBothCheatersShouldHaveZeroPointsAfter5Rounds() {
        Player player1 = new Cheater();
        Player player2 = new Cheater();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(5);

        assertEquals(0, player1.score.points());
        assertEquals(0, player2.score.points());
    }

    @Test
    public void testBothCooperatorsShouldHave10PointsAfter5Rounds() {
        Player player1 = new Cooperator();
        Player player2 = new Cooperator();
        Rounds rounds = new Rounds(player1, player2);

        rounds.transactFor(5);

        assertEquals(10, player1.score.points());
        assertEquals(10, player2.score.points());
    }

    @Test
    void testCooperativeAndCheaterShouldPlayMultipleRoundsCorrectly() {
        Player cheater = new Cheater();
        Player cooperator = new Cooperator();
        Rounds rounds = new Rounds(cheater, cooperator);

        rounds.transactFor(5);

        assertEquals(15, cheater.score.points());
        assertEquals(-5, cooperator.score.points());
    }

    // Test cases for CopyCat behavior
    @Test
    public void testCopyCatMimicsOpponentAfterFirstRound() {
        CopyCat copyCat = new CopyCat();
        Cooperator cooperator = new Cooperator();
        Rounds rounds = new Rounds(copyCat, cooperator);

        rounds.transactFor(1);

        assertTrue(copyCat.updateCooperation(cooperator));
    }

    @Test
    public void testCopyCatMimicsCheaterAfterFirstRound() {
        CopyCat copyCat = new CopyCat();
        Cheater cheater = new Cheater();
        Rounds rounds = new Rounds(copyCat, cheater);

        rounds.transactFor(1);

        assertFalse(copyCat.updateCooperation(cheater));
    }

    @Test
    public void testCopyCatAgainstCheater5Rounds() {
        CopyCat copyCat = new CopyCat();
        Cheater cheater = new Cheater();
        Rounds rounds = new Rounds(copyCat, cheater);

        rounds.transactFor(5);

        assertEquals(0, copyCat.score.points());
    }

    // Test cases for Detective behavior

    @Test
    public void testDetectiveCooperatesInFirstRound() {
        Player detective = new Detective();
        Player cooperator = new Cooperator();
        Rounds rounds = new Rounds(detective, cooperator);

        rounds.transactFor(1);

        assertTrue(detective.willCooperate);
    }

    @Test
    public void testDetectiveDefectsInSecondRound() {
        Player detective = new Detective();
        Player cheater = new Cheater();
        Rounds rounds = new Rounds(detective, cheater);

        // First round
        rounds.transactFor(1);
        assertTrue(detective.willCooperate);

        // Second round
        rounds.transactFor(1);
        assertFalse(detective.willCooperate);
    }

    @Test
    public void testDetectiveCooperatesInSubsequentRoundsAfterCheating() {
        Player detective = new Detective();
        Player cooperator = new Cooperator();
        Player cheater = new Cheater();
        Rounds rounds = new Rounds(detective, cheater);

        // First round against cheater
        rounds.transactFor(1);
        assertTrue(detective.willCooperate);

        // Second round (defects)
        rounds.transactFor(1);
        assertFalse(detective.willCooperate);

        // Third round (should cooperate again)
        rounds.transactFor(1);
        assertTrue(detective.willCooperate);
    }

    @Test
    public void testDetectiveAgainstCooperatorInMultipleRounds() {
        Player detective = new Detective();
        Player cooperator = new Cooperator();
        Rounds rounds = new Rounds(detective, cooperator);

        // Play 5 rounds
        rounds.transactFor(5);

        assertEquals(11, detective.score.points());
        assertEquals(7, cooperator.score.points());
    }

    @Test
    public void testDetectiveAgainstCheaterInMultipleRounds() {
        Player detective = new Detective();
        Player cheater = new Cheater();
        Rounds rounds = new Rounds(detective, cheater);

        // Play 5 rounds
        rounds.transactFor(5);

        assertEquals(-4, detective.score.points());
        assertEquals(12, cheater.score.points());
    }

    @Test
    public void testDetectiveVsDetectiveInFiveRounds() {
        Player detective1 = new Detective();
        Player detective2 = new Detective();
        Rounds rounds = new Rounds(detective1, detective2);

        // Play 5 rounds
        rounds.transactFor(5);

        assertEquals(8, detective1.score.points());
        assertEquals(8, detective2.score.points());
    }

}

package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    @BeforeEach
    public void setupTestGame() {
        testGame = new GameState();
    }

    @Test
    @DisplayName("Making sure Illegal Answer Doesn't Work")
    public void testConstructorWithIllegalAnswer() {
        assertThrows(IllegalWordException.class,
                () -> new GameState("QZXYX"));
    }

    @Test
    @DisplayName("Checking If Legal Answer Works")
    public void testConstructorWithLegalAnswer()
    {
        testGame = new GameState("Crate");
        assertNotNull(testGame);
        assertEquals(0,testGame.getGuessCount());
        assertFalse(testGame.isGameOver());
    }


}
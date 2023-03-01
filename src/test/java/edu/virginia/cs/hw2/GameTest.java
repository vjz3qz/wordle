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
        assertNotNull(testGame);
        assertEquals(0,testGame.getGuessCount());
        assertFalse(testGame.isGameOver());
    }

    @Test
    @DisplayName("testing to make sure if legal guess works")
    public void testSubmitValidGuess()
    {
        LetterResult[] res=testGame.submitGuess("CRATE");
        assertNotNull(res);
        assertEquals(1,testGame.getGuessCount());
        assertFalse(testGame.isGameOver());
        assertFalse(testGame.isWin());
        assertFalse(testGame.isLoss());
    }


}
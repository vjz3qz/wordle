package edu.virginia.cs.hw2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

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
        GameState game = new GameState("Crate");
        assertNotNull(game);
        assertEquals(0,game.getGuessCount());
        assertFalse(game.isGameOver());
    }


}
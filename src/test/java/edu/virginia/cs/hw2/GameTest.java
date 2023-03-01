package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {
    private GameState testGame;

    @BeforeEach
    public void setupTestGame() {
        DefaultDictionaryFactory dictionary=new DefaultDictionaryFactory();
        testGame = new GameState("Spare", dictionary.getDefaultGuessesDictionary(), 5, GameState.GameStatus.PLAYING);
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
        assertEquals(5,testGame.getGuessCount());
        assertFalse(testGame.isGameOver());
    }

    @Test
    @DisplayName("testing to make sure if legal guess works")
    public void testSubmitValidGuess()
    {
        testGame=new GameState("spare");
        LetterResult[] res=testGame.submitGuess("CRATE");
        assertNotNull(res);
        assertEquals(1,testGame.getGuessCount());
        assertFalse(testGame.isGameOver());
        assertFalse(testGame.isWin());
        assertFalse(testGame.isLoss());
    }

    @Test
    @DisplayName("testing to make sure if illegal guess works by throwing")
    public void testSubmitInvalidGuess()
    {
        assertThrows(IllegalWordException.class,()->testGame.submitGuess("1"));
    }

    @Test
    @DisplayName("testing to make sure if correct guess ends game in win")
    public void testSubmitCorrectGuess()
    {
        LetterResult[] res=testGame.submitGuess("Spare");
        assertNotNull(res);
        assertEquals(6,testGame.getGuessCount());
        assertTrue(testGame.isGameOver(), "said game is not over");
        assertTrue(testGame.isWin(), "said game is not a win");
        assertFalse(testGame.isLoss(), "said game is a loss");
    }

    @Test
    @DisplayName("testing to make sure if wrong guess ends game in loss")
    public void testSubmitLastWrongGuess()
    {
        LetterResult[] res=testGame.submitGuess("crate");
        assertNotNull(res);
        assertEquals(6,testGame.getGuessCount());
        assertTrue(testGame.isGameOver(), "said game is not over");
        assertTrue(testGame.isLoss(), "said game is not a loss");
        assertFalse(testGame.isWin(), "said game is a win");
    }
}
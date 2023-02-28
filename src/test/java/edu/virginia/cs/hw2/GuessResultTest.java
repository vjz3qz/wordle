package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GuessResultTest {
    //getGuessResult setGuess getGuess setAnswer getAnswer

    private GuessResult testGuessResult;

    @BeforeEach
    public void setupTestResult() {
        testGuessResult = new GuessResult();
    }

    @Test
    @DisplayName("GuessResult constructor verification.")
    public void testThrowsErrorOnUninitializedFields() {
        assertNull(testGuessResult.getGuess());
        assertNull(testGuessResult.getAnswer());
        assertThrows(IllegalStateException.class, () ->
                testGuessResult.getGuessResult());
    }

    @Test
    @DisplayName("Correct answer Guess Result Test")
    public void testLetterResultCorrectAnswer() {
        givenInputGuessAndAnswer("MATCH", "MATCH");

        LetterResult[] guessResult = testGuessResult.getGuessResult();

        assertEquals("GGGGG", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("incorrect guess result test")
    public void testLetterResultIncorrectAnswer() {
        givenInputGuessAndAnswer("MATCH", "CRATE");
        LetterResult[] guessResult = testGuessResult.getGuessResult();
        assertEquals("gYYYg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Guess: SALSA, answer: SALTS")
    public void testSalsaCase(){
        givenInputGuessAndAnswer("salsa", "SALTS");
        LetterResult[] guessResult= testGuessResult.getGuessResult();
        assertEquals("GGGYg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("Testing Guess: PAPER, Answer: APPLE")
    public void testRepeatLettersAnswer() {
        givenInputGuessAndAnswer("paper", "APPLE");
        LetterResult[] guessResult = testGuessResult.getGuessResult();
        assertEquals("YYGYg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("testing guess with repeat letters, one in the right spot")
    public void testRepeatLettersGuessOneRight() {
        givenInputGuessAndAnswer("paper", "plate");
        LetterResult[] guessResult = testGuessResult.getGuessResult();
        assertEquals("GYgYg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("repeated letters in guess in the wrong spot")
    public void testRepeatLettersGuessNoneRight() {
        givenInputGuessAndAnswer("teeth", "apple");
        LetterResult[] guessResult = testGuessResult.getGuessResult();
        assertEquals("gYggg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("tests Guess: SASSY, Answer: SALTS")
    public void testThreeRepeatLettersGuess()
    {
        givenInputGuessAndAnswer("SASSY", "salts");
        LetterResult[] guessResult = testGuessResult.getGuessResult();
        assertEquals("GGYgg", getLetterResultArrayAsString(guessResult));
    }

    @Test
    @DisplayName("setting an illegal guess test")
    public void testIllegalGuessSet()
    {
        assertThrows(IllegalWordException.class,()->givenInputGuessAndAnswer("crab", "CRATE"));
    }

    @Test
    @DisplayName("setting an illegal answer test")
    public void testIllegalAnswerSet()
    {
        assertThrows(IllegalWordException.class,()->givenInputGuessAndAnswer("crate", "crab"));
    }

    private void givenInputGuessAndAnswer(String guess, String answer) {
        testGuessResult.setGuess(guess);
        testGuessResult.setAnswer(answer);
    }

    @Test
    @DisplayName("Helper function that converts the LetterResult[] in String for ease of use")
    public void testGetLetterResultArrayAsString() {
        LetterResult[] testArray = {LetterResult.GREEN, LetterResult.GRAY, LetterResult.YELLOW,LetterResult.GREEN, LetterResult.YELLOW};
        assertEquals("GgYGY", getLetterResultArrayAsString(testArray));
    }

    private String getLetterResultArrayAsString(LetterResult[] letterResultArray) {
        StringBuilder builder = new StringBuilder(5);
        for (LetterResult letterResult : letterResultArray) {
            char letterResultCharacter = getCharacterForLetterResult(letterResult);
            builder.append(letterResultCharacter);
        }
        return builder.toString();
    }

    @Test
    @DisplayName("LetterResult.Green -> `G`")
    public void testGetCharacterForLetterResult_Green() {
        assertEquals('G', getCharacterForLetterResult(LetterResult.GREEN));
    }

    @Test
    @DisplayName("LetterResult.Yellow -> `Y`")
    public void testGetCharacterForLetterResult_Yellow() {
        assertEquals('Y', getCharacterForLetterResult(LetterResult.YELLOW));
    }

    @Test
    @DisplayName("LetterResult.Gray -> `g`")
    public void testGetCharacterForLetterResult_Gray() {
        assertEquals('g', getCharacterForLetterResult(LetterResult.GRAY));
    }



    private static char getCharacterForLetterResult(LetterResult letterResult) {
        return switch(letterResult) {
            case GRAY -> 'g';
            case GREEN -> 'G';
            case YELLOW -> 'Y';
        };
    }

}
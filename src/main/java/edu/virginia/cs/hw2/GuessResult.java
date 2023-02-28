package edu.virginia.cs.hw2;

import java.util.*;

public class GuessResult {
    public static final int GUESS_RESULT_ARRAY_SIZE = 5;
    private final LetterResult[] guessResult =
            {LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY, LetterResult.GRAY};
    private String answer; //always uppercase
    private String guess; //always uppercase

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        if(WordleDictionary.isLegalWordleWord(answer))
            this.answer = answer.toUpperCase();
        else {
            this.answer = null;
            throw new IllegalWordException("Answer parameter is illegal. Answer is set to null. Please input a new answer.");
        }
    }

    public String getGuess() {
        return guess;
    }

    public void setGuess(String guess) {
        if(WordleDictionary.isLegalWordleWord(guess))
            this.guess = guess.toUpperCase();
        else {
            this.guess = null;
            throw new IllegalWordException("Guess parameter is illegal. Guess is set to null. Please input a new guess.");
        }
    }

    public LetterResult[] getGuessResult() {
        verifyAllFieldsAreInitialized();
        if (guess.equals(answer))
            return getCorrectAnswerArray();
        Set<Integer> usedAnswerIndices = new HashSet<>();
        for (int i = 0; i < GUESS_RESULT_ARRAY_SIZE; i++) {
            char ch = guess.charAt(i); //gets character at each index
            if(answer.charAt(i)==ch)
            {
                guessResult[i]=LetterResult.GREEN;
                usedAnswerIndices.add(i);
            }
            else if(answer.indexOf(ch)>=0){ //if exists
                int indexOfNextCh = -1; //index of the next occurrence in the answer
                for (int j = 0; j < answer.length(); j++) { //iterator of answer
                    if (!usedAnswerIndices.contains(j) && answer.charAt(j) == ch)
                        indexOfNextCh = j;
                }
                if (indexOfNextCh != -1) { //if there is another occurrence of that letter in the answer
                    guessResult[i]=LetterResult.YELLOW;
                    usedAnswerIndices.add(indexOfNextCh);
                }
                else
                    guessResult[i]=LetterResult.GRAY;
            }
            else
                guessResult[i]=LetterResult.GRAY;
        }
        return guessResult;
        //TODO: Currently incomplete - implement via TDD - Write Tests in GuessResultsTest.java
    }

    private void verifyAllFieldsAreInitialized() {
        if (guess == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
        if (answer == null) {
            throw new IllegalStateException("The guess field in GuessResult must be initialized before calling getGuessResult");
        }
    }

    private LetterResult[] getCorrectAnswerArray() {
        fillGuessResultArrayWithOneColor(LetterResult.GREEN);
        return guessResult;
    }

    private void fillGuessResultArrayWithOneColor(LetterResult letterResult) {
        Arrays.fill(guessResult, letterResult);
    }


}

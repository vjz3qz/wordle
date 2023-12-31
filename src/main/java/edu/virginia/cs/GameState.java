package edu.virginia.cs;

public class GameState {

    public static final int MAX_GUESSES = 6;
    private String answer;
    private int guessCount;
    private GameStatus gameStatus;
    private WordleDictionary legalGuessDictionary;

    protected GameState(String answer, WordleDictionary dictionary, int guessCount, GameStatus status) {
        this.answer = answer.toUpperCase();
        this.legalGuessDictionary = dictionary;
        this.guessCount = guessCount;
        this.gameStatus = status;
        if (0 == legalGuessDictionary.getDictionarySize()) {
            throw new EmptyDictionaryException("Error: Cannot play Wordle with an Empty Dictionary");
        }
        if (!legalGuessDictionary.containsWord(answer)) {
            throw new IllegalWordException(
                    "Created a game with an illegal answer not found in the dictionary: " + answer);
        }
    }

    public GameState(String answer, WordleDictionary dictionary) {
        this(answer, dictionary, 0, GameStatus.PLAYING);
    }

    public GameState(String answer) {
        this(answer, getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static WordleDictionary getDefaultGuessesDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        return factory.getDefaultGuessesDictionary();
    }

    public GameState() {
        this(getRandomAnswerFromDefaultDictionary(), getDefaultGuessesDictionary(), 0, GameStatus.PLAYING);
    }

    private static String getRandomAnswerFromDefaultDictionary() {
        DefaultDictionaryFactory factory = new DefaultDictionaryFactory();
        WordleDictionary answersDictionary = factory.getDefaultAnswersDictionary();
        return answersDictionary.getRandomWord();
    }

    public boolean isGameOver() {
        return GameStatus.PLAYING != gameStatus;
    }

    public boolean isWin() {
        return GameStatus.WON == gameStatus;
    }

    public boolean isLoss() {
        return GameStatus.LOST == gameStatus;
    }

    public int getGuessCount() {
        return guessCount;
    }

    public int getRemainingGuesses() {
        return MAX_GUESSES - guessCount;
    }

    public String getAnswer() {
        return answer;
    }

    public LetterResult[] submitGuess(String guess) {
        if(!(gameStatus.equals(GameStatus.PLAYING)))
            throw new GameAlreadyOverException("Cannot submit guess! Game already over!");
        GuessResult guessResult = new GuessResult();
        guessResult.setGuess(guess);
        if (!legalGuessDictionary.containsWord(guessResult.getGuess()))
            throw new IllegalWordException(guess+" is an illegal guess not found in the dictionary!");
        guessResult.setAnswer(answer);
        guessCount++;
        int greenCount=0;
        for(int i=0; i<5;i++)
            if(guessResult.getGuessResult()[i].equals(LetterResult.GREEN))
                greenCount++;
        if(greenCount==5)
            gameStatus=GameStatus.WON;
        if(guessCount==MAX_GUESSES && gameStatus.equals(GameStatus.PLAYING))
            gameStatus=GameStatus.LOST;
        return guessResult.getGuessResult();
    }


    protected enum GameStatus {
        PLAYING, WON, LOST;
    }

}

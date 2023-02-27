package edu.virginia.cs.hw2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class WordleDictionaryTest {
    private static final String ONE_WORD_DICTIONARY_FILENAME = "/one_word_dictionary.txt";
    WordleDictionary testDictionary;

    @BeforeEach
    public void setupTestDictionary() {
        testDictionary = new WordleDictionary();
    }

    @Test
    @DisplayName("checks if one word dict has word and doesn't")
    public void testOneWordDictionary() {
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals(1, testDictionary.getDictionarySize());
        assertTrue(testDictionary.containsWord("BALDY"));
        assertFalse(testDictionary.containsWord("CRATE"));
    }

    @Test
    @DisplayName("checks contain word for empty dictionary")
    public void testContainsWordForEmptyDictionary()
    {
        assertFalse(testDictionary.containsWord("BALDY"));
    }

    @Test
    @DisplayName("testing if A123Z is a legal word, should be false")
    public void testLegalWord()
    {
        assertFalse(testDictionary.isLegalWordleWord("A123Z"));
    }
}

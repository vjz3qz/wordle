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
    @DisplayName("checks if one word dict has word and doesn't and size")
    public void testOneWordDictionary() {
        InputStream inputStream = WordleDictionaryTest.class.getResourceAsStream(ONE_WORD_DICTIONARY_FILENAME);
        testDictionary.addWordsFromInputStream(inputStream);
        assertEquals(1, testDictionary.getDictionarySize(), "returned dict size other than 1");
        assertTrue(testDictionary.containsWord("BALDY"), "returned contains BALDY as False");
        assertFalse(testDictionary.containsWord("CRATE"), "returned contains CRATE as True");
    }

    @Test
    @DisplayName("checks contain word and size for empty dictionary")
    public void testEmptyDictionary()
    {
        assertEquals(0, testDictionary.getDictionarySize(), "returned dict size other than 0");
        assertFalse(testDictionary.containsWord("BALDY"), "returned Contains BALDY when empty");
    }

    @Test
    @DisplayName("testing illegal words: A123Z, !KALE, crate, null, and CRAB")
    public void testIllegalWord()
    {
        assertFalse(testDictionary.isLegalWordleWord("A123Z"), "returned A123Z true");
        assertFalse(testDictionary.isLegalWordleWord("!KALE"), "returned !KALE true");
        assertFalse(testDictionary.isLegalWordleWord(null), "returned null true");
        assertFalse(testDictionary.isLegalWordleWord("CRAB"), "returned CRAB true");
    }


    @Test
    @DisplayName("testing legal words: CRATE, crate")
    public void testLegalWord()
    {
        assertTrue(testDictionary.isLegalWordleWord("CRATE"), "returned CRATE false");
        assertTrue(testDictionary.isLegalWordleWord("crate"), "returned crate false");
    }

    @Test
    @DisplayName("adding illegal words")
    public void testAddIllegalWord()
    {
        assertThrows(IllegalWordException.class,()->testDictionary.addWord("A123Z"));
        assertThrows(IllegalWordException.class,()->testDictionary.addWord("!kale"));
        assertThrows(IllegalWordException.class,()->testDictionary.addWord(null));
        assertThrows(IllegalWordException.class,()->testDictionary.addWord("crab"));
    }

    @Test
    @DisplayName("add legal words: crate and CRATE")
    public void testAddLegalWord()
    {
        assertDoesNotThrow(()->testDictionary.addWord("crate"));
        assertDoesNotThrow(()->testDictionary.addWord("CRATE"));
    }
}



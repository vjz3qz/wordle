package edu.virginia.cs;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultDictionaryFactoryTest {
    DefaultDictionaryFactory testFactory;

    @BeforeEach
    public void setupTestFactory() {
        testFactory = new DefaultDictionaryFactory();
    }


    @Test
    @DisplayName("test if default guesses not null")
    public void testGetDefaultGuessesDictionary() {
        WordleDictionary defaultGuessesDictionary = testFactory.getDefaultGuessesDictionary();
        assertNotNull(defaultGuessesDictionary, "guesses dict is null");
    }

    @Test
    @DisplayName("test if default answers not null")
    public void testGetDefaultAnswersDictionary()
    {
        WordleDictionary defaultAnswersDictionary = testFactory.getDefaultAnswersDictionary();
        assertNotNull(defaultAnswersDictionary, "answer dict is null");
    }

    @Test
    @DisplayName("tests if default dictionaries are set")
    public void testLoadDefaultDictionaries()
    {
        testFactory.loadDefaultDictionaries();
        testGetDefaultGuessesDictionary();
        testGetDefaultAnswersDictionary();
    }

}
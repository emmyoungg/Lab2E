package com.example.lab2e;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WordCounterClassUnitTest {
    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_countCharactersIsCalled_Then_NullPointerExceptionIsThrown(){
        WordCounter.countCharacters(null);
    }

    @Test(expected = NullPointerException.class)
    public void Given_NullString_When_countWordsIsCalled_Then_NullPointerExceptionIsThrown(){
        WordCounter.countWords(null);
    }

    @Test
    public void Given_EmptyString_When_countCharactersIsCalled_Then_Returned0(){
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = WordCounter.countCharacters(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_EmptyString_When_countWordsIsCalled_Then_Returned0(){
        final String givenString = "";

        final int expectedResult = 0;
        final int actualResult = WordCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfMultipleEmptySpaces_When_countWordsIsCalled_Then_Returned0(){
        final String givenString = "   ";

        final int expectedResult = 0;
        final int actualResult = WordCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfWords_When_countWordsIsCalled_Then_Returned3(){
        final String givenString = "just another test";

        final int expectedResult = 3;
        final int actualResult = WordCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfWords_When_countCharactersIsCalled_Then_Returned12(){
        final String givenString = "just another test";

        final int expectedResult = 17;
        final int actualResult = WordCounter.countCharacters(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNumbers_When_countCharactersIsCalled_Then_Returned6(){
        final String givenString = "123 23";

        final int expectedResult = 6;
        final int actualResult = WordCounter.countCharacters(givenString);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void Given_StringOfNumbers_When_countWordsIsCalled_Then_Returned0(){
        final String givenString = "123 23";

        final int expectedResult = 0;
        final int actualResult = WordCounter.countWords(givenString);

        assertEquals(expectedResult, actualResult);
    }
}
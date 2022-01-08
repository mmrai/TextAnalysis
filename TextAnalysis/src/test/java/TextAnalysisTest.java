import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class TextAnalysisTest {
    TextAnalysis ta = new TextAnalysis(System.getProperty("user.dir") + "/src/main/java/example.txt");

    TextAnalysisTest() throws IOException {
    }

    @org.junit.jupiter.api.Test
    void countWords() {
        String expectedString = "Word count = 9";
        String actualString = ta.countWords();
        assertEquals(expectedString, actualString);
    }

    @org.junit.jupiter.api.Test
    void averageWordLength() {
        String expectedString = "Average word length = 4.556";
        String actualString = ta.averageWordLength();
        assertEquals(expectedString, actualString);
    }

    @org.junit.jupiter.api.Test
    void getFreqForWordLength() {
        String expectedString = "Number of words of length 1 is 1";
        String actualString = ta.freqForWordLength(1);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 2 is 1";
        actualString = ta.freqForWordLength(2);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 3 is 1";
        actualString = ta.freqForWordLength(3);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 4 is 2";
        actualString = ta.freqForWordLength(4);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 5 is 2";
        actualString = ta.freqForWordLength(5);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 6 is 0";
        actualString = ta.freqForWordLength(6);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 7 is 1";
        actualString = ta.freqForWordLength(7);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 10 is 1";
        actualString = ta.freqForWordLength(10);
        assertEquals(expectedString, actualString);

        expectedString = "Number of words of length 20 is 0";
        actualString = ta.freqForWordLength(20);
        assertEquals(expectedString, actualString);
    }

    @org.junit.jupiter.api.Test
    void getMostFreqWordLength() {
        String expectedString = "The most frequently occurring word length is 2, for word lengths of 4, 5";
        String actualString = ta.mostFreqWordLength();
        assertEquals(expectedString, actualString);
    }
}
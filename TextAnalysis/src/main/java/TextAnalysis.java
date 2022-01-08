import java.io.IOException;
import java.math.RoundingMode;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class TextAnalysis {
    public static String[] words;
    public static HashMap<Integer, Integer> lengthCount;

    TextAnalysis(String strFileName) throws IOException {
        Path fileName = Path.of(strFileName);
        String text = "";
        try {
            text = Files.readString(fileName).trim();     // eliminate any leading and trailing spaces
        } catch (NoSuchFileException e) {
            System.err.println("NoSuchFileException: " + e.getMessage());
            System.exit(-1);
        }

        text = text.replaceAll("[\\p{Punct}&&[^-&/]]+", "");  // remove unnecessary punctuation
        if (!text.isEmpty())
            words = getWordsArray(text);

        lengthCount = buildWordLengthMap();     // build map of length to count key-value pairs
    }

    public String[] getWordsArray(String str) {
        return str.split("\\s+");   // split String into array of substrings separated on whitespace char
    }

    public char[] getCharsInWord(String str) {
        char[] chars = new char[str.length()];

        // copy each character of String into char array
        for (int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }

        return chars;
    }

    public String countWords() {
        return "Word count = " + words.length;      // return length property of words array
    }

    public String averageWordLength() {
        float total = 0f;
        for (String word : words) {
            total += getCharsInWord(word).length;
        }
        float avg = total / words.length;
        DecimalFormat df = new DecimalFormat("#.###");
        df.setRoundingMode(RoundingMode.CEILING);

        return "Average word length = " + df.format(avg);
    }

    public HashMap<Integer, Integer> buildWordLengthMap(){
        /*
        Iterate over words and build a hashmap with word length as key, which updates the value count of words for each
        of these lengths.
         */
        HashMap<Integer, Integer> lengthCount = new HashMap<>();
        for (String word : words) {
            if (!lengthCount.containsKey(word.length())) {
                lengthCount.put(word.length(), 1);
            } else {
                int count = lengthCount.get(word.length());
                lengthCount.replace(word.length(), count + 1);
            }
        }

        return lengthCount;
    }

    public String freqForWordLength(int n){
        if (n < 1)
            throw new IllegalArgumentException("A word must be at least 1 letter");

        int count = 0;
        if (lengthCount.containsKey(n))
            count = lengthCount.get(n);
        return "Number of words of length " + n + " is " + count;
    }

    public String mostFreqWordLength(){
        int highest = 0;
        ArrayList<Integer> lengths = new ArrayList<>();

        for (int length : lengthCount.keySet()) {
            if (lengthCount.get(length) > highest) {
                highest = lengthCount.get(length);
                lengths.clear();
                lengths.add(length);
            } else if (lengthCount.get(length) == highest) {
                lengths.add(length);
            }
        }

        String answer = "The most frequently occurring word length is 2, for word lengths of ";
        if (lengths.size() == 1) {
            answer += (lengths.get(0));
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < lengths.size() - 1; i++)
                sb.append(lengths.get(i)).append(", ");

            answer += sb.toString();
            answer += lengths.get(lengths.size() - 1);
        }

        return answer;
    }
}

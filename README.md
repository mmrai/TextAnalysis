# TextAnalysis
An API written in Java, to read the contents of a plain text file and enable the display of the total number of words, the average word length, the most frequently occurring word length, and a list of the number of words of each length.

Assumptions: 
- Punctuation is not counted as part of the word it is attached to except in the case of hyphenated words. 
    E.g. 'morning.' will be counted as 7 characters, 'don't' will be counted as 4 characters but 'real-time' will be 
    counted as 9 characters. This is following the generally accepted rule that a compound word is always treated as a 
    single word. Ref: https://wordribbon.tips.net/T009228_Ignoring_Hyphens_in_Word_Counts.html
- '&' may be counted as a word.
- Numerical data such as dates may be counted as words.
- Average word length is presented correct to 3 decimal places

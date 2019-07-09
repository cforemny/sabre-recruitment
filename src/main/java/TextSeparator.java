import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TextSeparator {

    private final Logger logger = Logger.getLogger(getClass());

    public static final String WHITE_SPACE = " ";
    public static final String EMPTY_REGEX = "";
    public static final String SPECIAL_CHARACTERS = "[^a-zA-Z]";

    //Remove all duplicates and special characters from text and sort
    public String getUniqueLettersInText(String text) {
        try {
            return text.toLowerCase().replaceAll(SPECIAL_CHARACTERS, EMPTY_REGEX).chars()
                    .distinct().mapToObj(c -> String.valueOf((char) c))
                    .sorted().collect(Collectors.joining());
        } catch (NullPointerException ex) {
            logger.info("Text cannot be null.");
            return EMPTY_REGEX;
        }
    }

    //Get all unique words from given text, skip one digit words
    public HashSet<String> getUniqueWordsFromText(String text) {

        try{
            return (HashSet<String>) Arrays.stream(text.toLowerCase().replaceAll(SPECIAL_CHARACTERS, WHITE_SPACE)
                    .split(WHITE_SPACE)).filter(word -> !word.isEmpty())
                    .collect(Collectors.toSet());
        }catch (NullPointerException ex) {
            logger.info("Text cannot be null.");
            return null;
        }
    }

    public Map<String, String> mapWordsToLetter(String text){

        Map<String, String> mappedWords = new HashMap<>();
        char[] chars = getUniqueLettersInText(text).toCharArray();
        Set<String> uniqueWordsFromText = getUniqueWordsFromText(text);
        for (char aChar : chars) {
            mappedWords.put(String.valueOf(aChar),getWordsWithSpecificDigit(aChar,uniqueWordsFromText));
        }

        return mappedWords;
    }

    private String getWordsWithSpecificDigit(char aChar, Set<String> words){

        StringBuilder sb = new StringBuilder();
        List<String> wordsWithDigit = words.stream().filter(digit -> digit.indexOf(aChar) != -1).collect(Collectors.toList());
        wordsWithDigit.forEach(word -> sb.append(" ").append(word).append(","));
        return sb.toString();

    }


}

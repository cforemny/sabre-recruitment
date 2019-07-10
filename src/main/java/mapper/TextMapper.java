package mapper;

import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Component
public class TextMapper {

    public static final String WHITE_SPACE = " ";
    public static final String EMPTY_REGEX = "";
    public static final String SPECIAL_CHARACTERS = "[^a-zA-Z]";

    //Remove all duplicates and special characters from text and sort
    public char[] getUniqueLettersInText(String text) {

        return text == null ? null : text.toLowerCase().replaceAll(SPECIAL_CHARACTERS, EMPTY_REGEX).chars()
                .distinct().mapToObj(c -> String.valueOf((char) c))
                .sorted().collect(Collectors.joining()).toCharArray();
    }

    //Get all unique words from given text, skip one digit words
    public HashSet<String> getUniqueWordsFromText(String text) {

        return text == null ? null : (HashSet<String>) Arrays.stream(text.toLowerCase().replaceAll(SPECIAL_CHARACTERS, WHITE_SPACE)
                .split(WHITE_SPACE)).filter(word -> !word.isEmpty())
                .collect(Collectors.toSet());

    }

    // Create map with unique letters from text as a key and maching words as a value
    public Map<String, String> mapWordsToLetter(String text) {

        Map<String, String> mappedWords = new HashMap<>();
        char[] chars = getUniqueLettersInText(text);
        Set<String> uniqueWordsFromText = getUniqueWordsFromText(text);
        try {
            for (char aChar : chars) {
                mappedWords.put(String.valueOf(aChar), getWordsWithSpecificDigit(aChar, uniqueWordsFromText));
            }
            return mappedWords;
        } catch (Exception ex) {
            return null;
        }
    }


    //Find all words which contains given char
    private String getWordsWithSpecificDigit(char aChar, Set<String> words) {

        StringBuilder sb = new StringBuilder();
        List<String> wordsWithDigit = words.stream().filter(digit -> digit.indexOf(aChar) != -1).sorted().collect(Collectors.toList());
        wordsWithDigit.forEach(word -> sb.append(" ").append(word).append(","));
        return sb.toString();

    }


}

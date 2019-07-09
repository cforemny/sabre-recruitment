import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextSeparatorTest {

    private static final String SAMPLE_CORRECT_TEXT = "ala ma kota, kot koduje w Javie kota";
    private static final String SAMPLE_INCORRECT_TEXT = "ala m!!a kot123a, kot koduj13e w Javie ko555ta";
    public static final String EMPTY_STRING = "";

    private Set<Character> charSet;


    private TextSeparator textSeparator;

    @Before
    public void setUp() {
        this.charSet = new HashSet<>();
        this.textSeparator = new TextSeparator();
    }

    @Test
    public void getUniqueLettersInTextWhenNullTest() {
        //given

        //when
        String result = textSeparator.getUniqueLettersInText(null);
        //then
        assert EMPTY_STRING.equals(result);
    }

    @Test
    public void getUniqueLettersInIncorrectTextTest() {
        //given


        //when
        String result = textSeparator.getUniqueLettersInText(SAMPLE_INCORRECT_TEXT);
        //then
        char[] chars = result.toCharArray();


        for (char aChar : chars) {
            assert charSet.add(aChar);
        }
    }

    @Test
    public void getUniqueLettersInTextTest() {
        //given

        //when
        String result = textSeparator.getUniqueLettersInText(SAMPLE_CORRECT_TEXT);
        //then
        char[] chars = result.toCharArray();

        for (char aChar : chars) {
            assert charSet.add(aChar);
        }
    }

    @Test
    public void findSpecialCharacterTest() {
        //given

        //when
        String result = textSeparator.getUniqueLettersInText(null);
        //then
        char[] chars = result.toCharArray();

        for (char aChar : chars) {
            assert Character.isLetterOrDigit(aChar) && !Character.isWhitespace(aChar);
        }
    }

    @Test
    public void findSpecialCharacterInNullTest() {
        //given

        //when
        String result = textSeparator.getUniqueLettersInText(null);
        //then
        assert EMPTY_STRING.equals(result);
    }

    @Test
    public void findSpecialCharacterWhenIncorrectTest() {
        //given

        //when
        String result = textSeparator.getUniqueLettersInText(SAMPLE_INCORRECT_TEXT);
        //then
        char[] chars = result.toCharArray();

        for (char aChar : chars) {
            assert Character.isLetterOrDigit(aChar) && !Character.isWhitespace(aChar);
        }
    }

    @Test
    public void getUniqueWordsFromNullTest(){
        //given

        //when
        Set<String> result = textSeparator.getUniqueWordsFromText(null);
        //then
        assert result == null;

    }

    @Test
    public void getUniqueWordsFromTextTest(){
        //given

        //when
        Set<String> result = textSeparator.getUniqueWordsFromText(SAMPLE_CORRECT_TEXT);
        //then
        assert !result.isEmpty() && result.size() == 6;
    }
    @Test
    public void mapWordsToLetterTest(){
        //given

        //when
        Map<String, String> result = textSeparator.mapWordsToLetter(SAMPLE_CORRECT_TEXT);
        //then
        for (String s : result.keySet()) {
            System.out.println(s + result.get(s));
        }
    }

}

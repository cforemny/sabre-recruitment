package mapper;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TextMapperTest {

    private TextMapper textMapper;

    @Before
    public void setUp() {
        this.textMapper = new TextMapper();
    }

    @Test
    public void getUniqueLettersInTextWhenNullTest() {
        //given

        //when
        char[] result = textMapper.getUniqueLettersInText(null);
        //then
        assert null == result;
    }

    @Test
    public void getUniqueLettersInIncorrectTextTest() {
        //given
        String incorrectText = "ala m!!a kot123a, kot koduj13e w Javie ko555ta";

        //when
        char[] result = textMapper.getUniqueLettersInText(incorrectText);
        //then
        assert result[4] == 'j' && result[7] == 'm';
    }

    @Test
    public void getUniqueLettersInTextTest() {
        //given
        String correctText = "ala ma kota, kot koduje w Javie kota";
        //when
        char[] result = textMapper.getUniqueLettersInText(correctText);
        //then
        assert result[0] == 'a' && result[1] == 'd' && result[2] == 'e';
    }


    @Test
    public void findSpecialCharacterInNullTest() {
        //given

        //when
        char[] result = textMapper.getUniqueLettersInText(null);
        //then
        assert result == null;
    }


    @Test
    public void getUniqueWordsFromNullTest() {
        //given

        //when
        Set<String> result = textMapper.getUniqueWordsFromText(null);
        //then
        assert result == null;

    }

    @Test
    public void getUniqueWordsFromTextTest() {
        //given
        String correctText = "ala ma ala, ala koduje w Javie ala";
        HashSet expectedSet = new HashSet(Arrays.asList("ala", "ma", "koduje", "javie", "w"));
        //when
        Set<String> result = textMapper.getUniqueWordsFromText(correctText);
        //then
        assert !result.isEmpty() && result.size() == 5 && result.containsAll(expectedSet);
    }

    @Test
    public void mapWordsToLetterTest() {
        //given
        String correctText = "ala ma kota, kot koduje w Javie kota";
        String expectedValueForLettera = " ala, javie, kota, ma,";
        //when
        Map<String, String> result = textMapper.mapWordsToLetter(correctText);
        //then
        assert result.get("a").equals(expectedValueForLettera);
    }

    @Test
    public void mapWordsToLetterWhenTextIsNullTest() {
        //given
        //when
        Map<String, String> result = textMapper.mapWordsToLetter(null);
        //then
        assert result == null;
    }

}

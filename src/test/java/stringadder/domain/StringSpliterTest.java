package stringadder.domain;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringSpliterTest {
    @Test
    void 구분자를_기준으로_숫자_문자열을_문자열_리스트로_반환하는지_테스트() {
        String numbersWithSeparator = "1,2,3";
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3"));
        List<String> separator = new ArrayList<>(Arrays.asList(","));

        assertThat(StringSpliter.splitBySeparators(numbersWithSeparator, separator)).isEqualTo(expected);
    }

    @Test
    void 구분자들을_기준으로_숫자_문자열을_문자열_리스트로_반환하는지_테스트() {
        String numbersWithSeparator = "1,2,3:4";
        List<String> expected = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));
        List<String> separator = new ArrayList<>(Arrays.asList(",", ":"));

        assertThat(StringSpliter.splitBySeparators(numbersWithSeparator, separator)).isEqualTo(expected);
    }

    @Test
    void 커스텀_구분자를_추가저장_하는기능_테스트() {
        String input = "//;\n1;2;3";
        StringSpliter testStringSpliter = new StringSpliter();

        testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(testStringSpliter).isEqualTo(new StringSpliter(Arrays.asList(";")));
    }

    @Test
    void 커스텀_구분자가_없을떄_문자열을_제대로_반환하는지_테스트() {
        String input = "1,2,3";
        StringSpliter testStringSpliter = new StringSpliter();

        String numberString = testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(numberString).isEqualTo(input);
    }


    @Test
    void 커스텀_구분자를_제외한_문자열을_반환하는지_테스트() {
        String input = "//;\n1;2;3";
        String expected = "1;2;3";
        StringSpliter testStringSpliter = new StringSpliter();

        String numberString = testStringSpliter.setAdditionalSeparatorsFrom(input);

        assertThat(numberString).isEqualTo(expected);
    }

}

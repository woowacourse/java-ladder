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
    void 숫자열을_분리해주는_기능() {
        String input = "//;\n1;2;3";
        String expected = "1;2;3";

        assertThat(StringSpliter.splitToNumberString(input)).isEqualTo(expected);
    }
}

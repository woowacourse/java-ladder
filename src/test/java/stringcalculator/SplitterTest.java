package stringcalculator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SplitterTest {
    List<Integer> numbers;
    DelimiterType blank = DelimiterType.BLANK;
    DelimiterType customDelimiter = DelimiterType.CUSTOM_DELIMITER;
    DelimiterType basicDelimiter = DelimiterType.BASIC_DELIMITER;

    @BeforeEach
    void setup() {
        numbers = new ArrayList<Integer>();
    }

    @Test
    void null_입력() {
        numbers.add(0);
        String formula = null;
        assertThat(Splitter.split(blank, formula)).isEqualTo(numbers);
    }

    @Test
    void 빈문자열_입력() {
        numbers.add(0);
        String formula = "";
        assertThat(Splitter.split(blank, formula)).isEqualTo(numbers);
    }

    @Test
    void 커스텀_구분자_포함_확인() {
        numbers = Arrays.asList(1, 2, 3);
        String formula = "//;\n1;2;3";
        assertThat(Splitter.split(customDelimiter, formula)).isEqualTo(numbers);
    }

    @Test
    void 커스텀_구분자가_포함된_잘못된_문자열() {
        String formula = "//;\n1,2,3";
        assertThrows(RuntimeException.class, () -> Splitter.split(DelimiterType.findDelimiterType(formula), formula));
    }

    @Test
    void 기본_구분자가_포함된_올바른_문자열_검사() {
        numbers = Arrays.asList(1, 2, 3);
        String formula = "1,2:3";
        assertThat(Splitter.split(basicDelimiter, formula)).isEqualTo(numbers);
    }

    @Test
    void 기본_구분자가_포함된_잘못된_문자열_검사() {
        String formula = "1;2:3";
        assertThrows(RuntimeException.class, () -> Splitter.split(DelimiterType.findDelimiterType(formula), formula));
    }

    @Test
    void 숫자만_있는_문자열_검사() {
        numbers.add(5);
        String formula = "5";
        assertThat(Splitter.split(basicDelimiter, formula)).isEqualTo(numbers);
    }

    @AfterEach
    void tearDown() {
        numbers = null;
    }
}

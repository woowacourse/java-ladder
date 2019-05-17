package stringcalculator;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTypeTest {
    List<Integer> numbers;

    @BeforeEach
    void setup() {
        numbers = new ArrayList<Integer>();
    }

    @Test
    void null_입력() {
        numbers.add(0);
        String formula = null;
        assertThat(DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula)).isEqualTo(numbers);
    }

    @Test
    void 빈문자열_입력() {
        numbers.add(0);
        String formula = "";
        assertThat(DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula)).isEqualTo(numbers);
    }

    @Test
    void 커스텀_구분자_포함_확인() {
        numbers = Arrays.asList(1, 2, 3);
        String formula = "//;\n1;2;3";
        assertThat(DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula)).isEqualTo(numbers);
    }

    @Test
    void 커스텀_구분자가_포함된_잘못된_문자열() {
        String formula = "//;\n1,2,3";
        assertThrows(RuntimeException.class, () -> DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula));
    }

    @Test
    void 기본_구분자가_포함된_올바른_문자열_검사() {
        numbers = Arrays.asList(1, 2, 3);
        String formula = "1,2:3";
        assertThat(DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula)).isEqualTo(numbers);
    }

    @Test
    void 기본_구분자가_포함된_잘못된_문자열_검사() {
        String formula = "1;2:3";
        assertThrows(RuntimeException.class, () -> DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula));
    }

    @Test
    void 숫자만_있는_문자열_검사() {
        numbers.add(5);
        String formula = "5";
        assertThat(DelimiterType.findDelimiterType(formula).getSeparatedNumbers(formula)).isEqualTo(numbers);
    }

    @AfterEach
    void tearDown() {
        numbers = null;
    }
}

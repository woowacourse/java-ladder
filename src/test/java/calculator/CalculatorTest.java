package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 콤마_구분자_구분하기_2개() {
        String input = "1,2";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2"));
    }

    @Test
    void 콤마_구분자_구분하기_3개() {
        String input = "1,2,3";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 콜론_구분자_구분하기_2개() {
        String input = "1:2";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2"));
    }

    @Test
    void 콜론_구분자_구분하기_3개() {
        String input = "1:2:3";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 콜론_콤마_구분자_구분하기_3개() {
        String input = "1,2:3";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 입력이_빈문자열인_경우() {
        String input = "";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("0"));
    }

    @Test
    void 입력이_널인_경우() {
        String input = null;
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("0"));
    }

    @Test
    void 커스텀_구분자_나누기() {
        String input = "//:\n1:2:3";
        List<String> result = Calculator.customSplitNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자_나누기2() {
        String input = "////\n1//2//3";
        List<String> result = Calculator.customSplitNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자_나누기_inputSplit에서() {
        String input = "//:\n1:2:3";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 문자열_숫자를_정수형으로_변환하기() {
        String input = "//:\n1:2:3";
        List<Integer> result = Calculator.getNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 문자열_숫자를_정수형으로_변환하기2() {
        String input = "1,2,3";
        List<Integer> result = Calculator.getNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 문자열_숫자를_정수형으로_변환하기3() {
        String input = "3";
        List<Integer> result = Calculator.getNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(3));
    }
}

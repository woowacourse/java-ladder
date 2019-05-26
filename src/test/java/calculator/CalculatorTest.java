package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
        String input = "//:\\n1:2:3";
        List<String> result = Calculator.customSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자_나누기2() {
        String input = "////\\n1//2//3";
        List<String> result = Calculator.customSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자_나누기3() {
        String input = "//*\\n1*2*3";
        List<String> result = Calculator.customSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 커스텀_구분자_나누기_inputSplit에서() {
        String input = "//:\\n1:2:3";
        List<String> result = Calculator.inputSplit(input);
        assertThat(result).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    void 문자열_숫자를_정수형으로_변환하기() {
        String input = "//:\\n1:2:3";
        List<Integer> result = Calculator.convertNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 문자열_숫자를_정수형으로_변환하기2() {
        String input = "1,2,3";
        List<Integer> result = Calculator.convertNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 숫자_1개_입력할_경우() {
        String input = "3";
        List<Integer> result = Calculator.convertNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(3));
    }

    @Test
    void 공백_있는_경우() {
        String input = "1, 2, 3";
        List<Integer> result = Calculator.convertNumbers(input);
        assertThat(result).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 음수가_포함된_경우() {
        String input = "1, -2, 3";
        assertThrows(RuntimeException.class, () -> {
            Calculator.convertNumbers(input);
        });
    }

    @Test
    void 음수가_포함된_경우_함수_사용() {
        assertThrows(RuntimeException.class, () -> {
            Calculator.checkMinusNumber(-1);
        });
    }

    @Test
    void 숫자_이외에_다른_입력값이_올_경우() {
        String input = "a, 2, 3";
        assertThrows(RuntimeException.class, () -> {
            Calculator.convertNumbers(input);
        });
    }

    @Test
    void 결과값_출력하기() {
        String input = "//a\\n1a2a3";
        assertThat(Calculator.sumNumber(Calculator.convertNumbers(input))).isEqualTo(6);
    }

    @Test
    void 결과값_출력하기_뒤에_숫자_안씀() {
        String input = "1,3,2, ";
        assertThat(Calculator.sumNumber(Calculator.convertNumbers(input))).isEqualTo(6);
    }
}

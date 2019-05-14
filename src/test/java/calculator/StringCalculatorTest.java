package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {
    @Test
    void 문자열_배열_계산() {
        String[] numbers = {"1", "2", "3"};

        assertThat(StringCalculator.calculate(numbers)).isEqualTo(6);
    }

    @Test
    void 문자열_계산() {
        String input = "1,2,3";
        String[] numbers = StringSplitter.split(input);

        assertThat(StringCalculator.calculate(numbers)).isEqualTo(6);
    }

    @Test
    void 음수값_예외() {
        String[] numbers = {"-1", "2"};

        assertThrows(RuntimeException.class, () -> {
            StringCalculator.calculate(numbers);
        });
    }

    @Test
    void 숫자아닌값_예외() {
        String[] notNumbers = {"$", "b"};

        assertThrows(RuntimeException.class, () -> {
            StringCalculator.calculate(notNumbers);
        });
    }

    @Test
    void null_체크() {
        String[] input = null;
        assertThat(StringCalculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void 빈_문자열_체크() {
        String[] input = {};
        assertThat(StringCalculator.calculate(input)).isEqualTo(0);
    }

    @Test
    void 숫자_하나_체크() {
        String[] input = {"1"};
        assertThat(StringCalculator.calculate(input)).isEqualTo(1);
    }
}

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void 숫자_하나_문자열() {
        String[] inputs = {"5", "4", "19", "240"};
        int[] wants = {5, 4, 19, 240};

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        }
    }

    @Test
    void 숫자_두_개_이상문자열() {
        String[] inputs = {"1,2", "1,2,3"};
        int[] wants = {3, 6};

        IntStream.range(0, inputs.length).forEach((i) -> {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        });
    }

    @Test
    void 기본_구분자들_사용() {
        String[] inputs = {"1,2:3", "1:2,3"};
        int[] wants = {6, 6};

        IntStream.range(0, inputs.length).forEach((i) -> {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        });
    }

    @Test
    void 커스텀_구분자_사용() {
        String[] inputs = {"//;\n1;2;3", "//a\n1a2a3", "//ab\n1ab2ab3"};
        int[] wants = {6, 6, 6};

        IntStream.range(0, inputs.length).forEach((i) -> {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        });
    }

    @Test
    void 커스텀_구분자_및_기존_구분자_혼합() {
        String[] inputs = {"//a\n1a2,3:4"};
        int[] wants = {10};

        IntStream.range(0, inputs.length).forEach((i) -> {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        });
    }

    @Test
    void 빈_문자열() {
        assertThat(calculator.evaluate("")).isEqualTo(0);
    }

    @Test
    void null_입력() {
        assertThat(calculator.evaluate(null)).isEqualTo(0);
    }

}

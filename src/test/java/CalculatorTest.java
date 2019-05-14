import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void 숫자_하나_문자열() {
        String[] inputs = {"5", "4", "19", "240"};
        int[] wants = {5, 4, 19, 240};
        Calculator calculator = new Calculator();

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
        Calculator calculator = new Calculator();

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
        Calculator calculator = new Calculator();

        IntStream.range(0, inputs.length).forEach((i) -> {
            String input = inputs[i];
            int want = wants[i];

            assertThat(calculator.evaluate(input)).isEqualTo(want);
        });
    }
}

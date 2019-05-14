import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

    @Test
    void 숫자_하나_문자열() {
        String[] inputs = {"5", "4", "19", "240"};
        int[] expecteds = {5, 4, 19, 240};
        Calculator calculator = new Calculator();

        for (int i = 0; i < inputs.length; i++) {
            String input = inputs[i];
            int expected = expecteds[i];

            assertThat(calculator.evaluate(input)).isEqualTo(expected);
        }
    }
}

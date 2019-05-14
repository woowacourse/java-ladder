package StringAddCalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringAddCalculatorTest {
    @Test
    void 구분자_구분() {
        String input = "1,2,3";
        String[] splitter = {","};
        List<Integer> output = StringAddCalculator.splitString(input, splitter);
        List<Integer> result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);

        input = "1:2:3";
        splitter[0] = ":";
        output = StringAddCalculator.splitString(input, splitter);
        result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 콜론_콤마_섞여있을때() {
        String input = "1,2:3";
        String[] splitter = {",", ":"};
        List<Integer> output = StringAddCalculator.splitString(input, splitter);
        List<Integer> result = Arrays.asList(1, 2, 3);
        assertThat(output).isEqualTo(result);
    }

    @Test
    void 덧셈() {
        List<Integer> input = Arrays.asList(1, 2, 3);
        assertThat(StringAddCalculator.add(input)).isEqualTo(6);
    }
}

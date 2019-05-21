package additioncalculator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {
    @Test
    void 계산1() {
        List<Integer> numbers = InputValues.extractNumbers("//a\n//b\n1:2a3b6");

        assertThat(Calculator.calculate(numbers)).isEqualTo(12);
    }

    @Test
    void 계산2() {
        List<Integer> numbers = InputValues.extractNumbers("//a\n100:150,150a100");

        assertThat(Calculator.calculate(numbers)).isEqualTo(500);
    }
}

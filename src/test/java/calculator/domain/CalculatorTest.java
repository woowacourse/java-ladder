package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    private Calculator calculator;

    @Test
    public void 계산기클래스가_제대로_생성되는지() {
        calculator = new Calculator("1");
        assertThat(calculator).isEqualTo(new Calculator("1"));
    }

    @Test
    public void 문자열_분리를_쉼표로_제대로_하는지() {
        calculator = new Calculator("1,2,3");
        assertThat(calculator.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 문자열_분리를_콜론으로_제대로_하는지() {
        calculator = new Calculator("1:2:3");
        assertThat(calculator.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 문자열_분리를_쉼표와_콜론으로_제대로_하는지() {
        calculator = new Calculator("1,2:3");
        assertThat(calculator.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }

    @Test
    public void 커스텀_구분자로_분리를_제대로_하는지() {
        calculator = new Calculator("//;\n1;2;3");
        assertThat(calculator.splitExpression()).isEqualTo(Arrays.asList("1", "2", "3"));
    }
}

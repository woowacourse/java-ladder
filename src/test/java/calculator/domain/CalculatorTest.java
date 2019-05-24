package calculator.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    @Test
    void 합() {
        assertThat(new Calculator(Arrays.asList(1, 2, 3)).sum()).isEqualTo(6);
    }

    @Test
    void 인풋없을때() {
        assertThat(new Calculator(Arrays.asList()).sum()).isEqualTo(0);
    }

    @Test
    void 숫자하나일때() {
        assertThat(new Calculator(Arrays.asList(2)).sum()).isEqualTo(2);
    }
}
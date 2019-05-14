package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static calculator.Calculator.split;
import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void 공백문자열구분테스트() {
        assertThat(split("")).isEqualTo(null);

    }

    @Test
    void 문자열콤마구분테스트() {
        assertThat(split("1,2,3")).isEqualTo(Arrays.asList(1, 2, 3));
    }

    @Test
    void 문자열콜론구분테스트() {
        assertThat(split("1,2,:3")).isEqualTo(Arrays.asList(1, 2, 3));
    }
}

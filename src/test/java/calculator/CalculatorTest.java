package calculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static calculator.Calculator.add;
import static calculator.Calculator.split;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    @Test
    void 공백문자열구분테스트() {
        assertThat(split("")).isEqualTo(null);
    }

    @Test
    void 문자열콤마구분테스트() {
        assertThat(split("1,2,3")).isEqualTo(Arrays.asList(new Positive(1), new Positive(2), new Positive(3)));
    }

    @Test
    void 문자열콜론구분테스트() {
        assertThat(split("1,2,:3")).isEqualTo(Arrays.asList(new Positive(1), new Positive(2), new Positive(3)));
    }

    @Test
    void 커스텀구분자테스트() {
        assertThat(split("//;\n1;2;3")).isEqualTo(Arrays.asList(new Positive(1), new Positive(2), new Positive(3)));
    }

    @Test
    void 문자열콤마더하기테스트() {
        assertThat(Calculator.add("1,2,3")).isEqualTo(6);
    }

    @Test
    void 문자열콜론더하기테스트() {
        assertThat(Calculator.add("1,2,:3")).isEqualTo(6);
    }

    @Test
    void 문자열커스텀더하기테스트() {
        assertThat(Calculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 음수입력테스트() {
        assertThrows(IllegalArgumentException.class, () -> add("-1:2:3"));
    }
}

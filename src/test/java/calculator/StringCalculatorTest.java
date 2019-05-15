package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 빈_문자열_입력시_0반환() {
        assertThat(stringCalculator.input("")).isEqualTo(0);
    }

    @Test
    void null_입력시_0반환() {
        assertThat(stringCalculator.input(null)).isEqualTo(0);
    }
}
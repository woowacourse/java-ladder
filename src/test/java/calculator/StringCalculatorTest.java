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

    @Test
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환() {
        assertThat(stringCalculator.input("1")).isEqualTo(1);
    }

    @Test
    void 숫자_두개를_컴마_구분자로_입력할_경우_두_숫자의_합을_반환() {
        assertThat(stringCalculator.input("1,1")).isEqualTo(2);
    }
}
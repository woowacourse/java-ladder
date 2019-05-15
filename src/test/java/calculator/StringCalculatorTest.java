package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @Test
    void 빈_문자열_입력시_0반환() {
        StringCalculator stringCalculator = new StringCalculator();

        assertThat(stringCalculator.input("")).isEqualTo(0);
    }
}
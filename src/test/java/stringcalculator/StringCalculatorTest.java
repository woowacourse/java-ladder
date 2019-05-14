package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringCalculatorTest {
    StringCalculator stringCalculator;

    @Test
    void null_입력() {
        stringCalculator = new StringCalculator(null);
        assertThat(stringCalculator.calculate()).isZero();
    }

    @Test
    void 빈문자열_입력() {
        stringCalculator = new StringCalculator("");
        assertThat(stringCalculator.calculate()).isZero();
    }

}

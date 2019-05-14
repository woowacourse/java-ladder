package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

    @Test
    void 커스텀_구분자_포함_확인() {
        stringCalculator = new StringCalculator("//;\n1;2;3");
        assertThat(stringCalculator.calculate()).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_포함된_잘못된_문자열() {
        assertThrows(RuntimeException.class, () -> new StringCalculator("//;\n1,2,3"));
    }

}

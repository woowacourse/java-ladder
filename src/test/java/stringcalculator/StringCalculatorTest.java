package stringcalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StringCalculatorTest {

    @Test
    void null_입력() {
        assertThat(new StringCalculator(null).calculate()).isZero();
    }

    @Test
    void 빈문자열_입력() {
        assertThat(new StringCalculator("").calculate()).isZero();
    }

    @Test
    void 커스텀_구분자_포함_확인() {
        assertThat(new StringCalculator("//;\n1;2;3").calculate()).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자가_포함된_잘못된_문자열() {
        assertThrows(RuntimeException.class, () -> new StringCalculator("//;\n1,2,3"));
    }

    @Test
    void 기본_구분자가_포함된_올바른_문자열_검사() {
        assertThat(new StringCalculator("1,2:3").calculate()).isEqualTo(6);
    }

    @Test
    void 기본_구분자가_포함된_잘못된_문자열_검사() {
        assertThrows(RuntimeException.class, () -> new StringCalculator("1-2,3"));
    }

    @Test
    void 숫자만_있는_문자열_검사(){
        assertThat(new StringCalculator("1").calculate()).isEqualTo(1);
    }

    @Test
    void 음수_검사(){
        assertThrows(RuntimeException.class, () -> new StringCalculator("1,-2,3"));
    }
}

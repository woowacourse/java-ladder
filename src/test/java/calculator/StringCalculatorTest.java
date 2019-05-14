package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 커스텀_구분자_생성() {
        assertThat(stringCalculator.createCustomSeparator("//;\n1:3")).isEqualTo(new CustomSeparator(";"));
    }

    @Test
    void 커스텀_지정자_두_개_이상일때_예외_발생() {
        assertThatThrownBy(() -> stringCalculator.createCustomSeparator("//;\n//'\n1:5")).isInstanceOf(IllegalArgumentException.class);
    }

    /*
    TODO 예외처리
    @Test
    void 커스텀_지정자가_숫자인_경우_예외_발생() {
        assertThatThrownBy(() -> stringCalculator.createCustomSeparator("//0\n5:1")).isInstanceOf(IllegalArgumentException.class);
    }
    */

    @Test
    void 커스텀_지정자가_두_글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> stringCalculator.createCustomSeparator("//;?\n5:1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_지정자가_NULL_예외_발생() {
        assertThat(stringCalculator.createCustomSeparator(null)).isNull();
    }

    @Test
    void 커스텀_지정자가_빈값일_경우_예외_발생() {
        assertThat(stringCalculator.createCustomSeparator("")).isNull();
    }

    @Test
    void 커스텀_기준으로_나누기() {
        String temp = "1,2:3";
        assertThat(stringCalculator.splitBySeparator(temp)).contains(1,2,3);
    }


}

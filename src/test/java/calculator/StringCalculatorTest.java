package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    private StringCalculator stringCalculator;

    @BeforeEach
    void setUp() {
        stringCalculator = new StringCalculator();
    }

    @Test
    void 문자열_더하기_커스텀() {
        assertThat(stringCalculator.add("//;\n1;2;3")).isEqualTo(6);
    }

    @Test
    void 문자열_더하기_한_개() {
        assertThat(stringCalculator.add("1")).isEqualTo(1);
    }

    @Test
    void 문자열_더하기_빈칸() {
        assertThat(stringCalculator.add("")).isEqualTo(0);
    }

    @Test
    void 문자열_더하기() {
        assertThat(stringCalculator.add("1:2")).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_생성() {
        assertThat(stringCalculator.createCustomSeparator("//;")).isEqualTo(new CustomSeparator(";"));
    }

    @Test
    void 커스텀_지정자가_두_글자_이상인_경우_예외_발생() {
        assertThatThrownBy(() -> stringCalculator.createCustomSeparator("//;?\n5:1")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 커스텀_기준으로_나누기() {
        String temp = "1,2:3";
        assertThat(stringCalculator.splitBySeparator(temp)).contains(1, 2, 3);
    }

    @Test
    void 음수(){
        assertThatThrownBy(() -> stringCalculator.createCustomSeparator("-1:1")).isInstanceOf(RuntimeException.class);
    }

}

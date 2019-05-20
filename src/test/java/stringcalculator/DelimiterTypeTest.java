package stringcalculator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.registerCustomDateFormat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTypeTest {
    DelimiterType blank = DelimiterType.BLANK;
    DelimiterType customDelimiter = DelimiterType.CUSTOM_DELIMITER;
    DelimiterType basicDelimiter = DelimiterType.BASIC_DELIMITER;

    @Test
    void null_입력() {
        String formula = null;
        assertThat(DelimiterType.findDelimiterType(formula)).isEqualTo(blank);
    }

    @Test
    void 빈문자열_입력() {
        String formula = "";
        assertThat(DelimiterType.findDelimiterType(formula)).isEqualTo(blank);
    }

    @Test
    void 커스텀_구분자_포함_확인() {
        String formula = "//;\n1;2;3";
        assertThat(DelimiterType.findDelimiterType(formula)).isEqualTo(customDelimiter);
    }

    @Test
    void 기본_구분자가_포함된_올바른_문자열_검사() {
        String formula = "1,2:3";
        assertThat( DelimiterType.findDelimiterType(formula)).isEqualTo(basicDelimiter);
    }

    @Test
    void 숫자만_있는_문자열_검사() {
        String formula = "5";
        assertThat( DelimiterType.findDelimiterType(formula)).isEqualTo(basicDelimiter);
    }

    @Test
    void 잘못된_문자열_검사(){
        assertThrows(RuntimeException.class, () -> DelimiterType.findDelimiterType("1=5=4"));
    }
}

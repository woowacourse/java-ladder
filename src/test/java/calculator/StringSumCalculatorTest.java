package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class StringSumCalculatorTest {
    private StringSumCalculator stringSumCalculator;

    @BeforeEach
    void setUp() {
        stringSumCalculator = new StringSumCalculator();
    }

    @Test
    void 빈_문자열_입력시_0반환() {
        assertThat(stringSumCalculator.calculateFormula("")).isEqualTo(0);
    }

    @Test
    void null_입력시_0반환() {
        assertThat(stringSumCalculator.calculateFormula(null)).isEqualTo(0);
    }

    @Test
    void 숫자_하나를_문자열로_입력할_경우_해당_숫자를_반환() {
        assertThat(stringSumCalculator.calculateFormula("1")).isEqualTo(1);
    }

    @Test
    void 숫자_2개이상을_컴마_구분자로_입력할_경우_모든_숫자의_합을_반환() {
        assertThat(stringSumCalculator.calculateFormula("1,1")).isEqualTo(2);
        assertThat(stringSumCalculator.calculateFormula("1,2,3")).isEqualTo(6);
        assertThat(stringSumCalculator.calculateFormula("1,2,3,4")).isEqualTo(10);
        assertThat(stringSumCalculator.calculateFormula("1,2,3,4,5")).isEqualTo(15);
    }

    @Test
    void 구분자로_콜론을_사용() {
        assertThat(stringSumCalculator.calculateFormula("1:1")).isEqualTo(2);
        assertThat(stringSumCalculator.calculateFormula("1:1:1")).isEqualTo(3);
        assertThat(stringSumCalculator.calculateFormula("1:1,1")).isEqualTo(3);
    }

    @Test
    void 커스텀_구분자_지정() {
        assertThat(stringSumCalculator.calculateFormula("//;\n1;1")).isEqualTo(2);
    }

    @Test
    void 음수가_입력되면_RuntimeException() {
        assertThrows(RuntimeException.class, () -> {
            stringSumCalculator.calculateFormula("-1");
        });
    }
}
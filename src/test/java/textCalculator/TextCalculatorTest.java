package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextCalculatorTest {
    @Test
    void 숫자만입력() {
        assertThat(new TextCalculator().calculate("1")).isEqualTo(1);
    }

    @Test
    void 쉼표구분자포함() {
        assertThat(new TextCalculator().calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론구분자포함() {
        assertThat(new TextCalculator().calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 콜론쉼표구분자포함() {
        assertThat(new TextCalculator().calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀구분자포함() {
        assertThat(new TextCalculator().calculate("//;\n1;2,3")).isEqualTo(6);
    }

    @Test
    void 커스텀구분자여러개포함() {
        assertThat(new TextCalculator().calculate("//;.?\n1;2,3.1?1")).isEqualTo(8);
    }

    @Test
    void null입력() {
        assertThat(new TextCalculator().calculate(null)).isEqualTo(0);
    }

    @Test
    void 빈문자열입력() {
        assertThat(new TextCalculator().calculate("")).isEqualTo(0);
    }
}

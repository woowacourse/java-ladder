package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void 빈문자열입력1() {
        assertThat(new TextCalculator().calculate("")).isEqualTo(0);
    }

    @Test
    void 빈문자열입력2() {
        assertThat(new TextCalculator().calculate("//!?\n")).isEqualTo(0);
    }

    @Test
    void 정규표현식특수문자커스텀구분자1() {
        assertThat(new TextCalculator().calculate("//$\n1$2,3")).isEqualTo(0);
    }

    @Test
    void 음수입력1() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("-2");
        });
    }

    @Test
    void 음수입력2() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("-1,2,3");
        });
    }

    @Test
    void 음수입력3() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("//!\n-1!2,3");
        });
    }

    @Test
    void 금지된커스텀구분자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("//-\n1!2,3");
        });
    }
}

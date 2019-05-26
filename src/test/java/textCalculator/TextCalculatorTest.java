package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TextCalculatorTest {
    @Test
    void 숫자만_입력() {
        assertThat(new TextCalculator().calculate("1")).isEqualTo(1);
    }

    @Test
    void 쉼표_구분자_포함() {
        assertThat(new TextCalculator().calculate("1,2")).isEqualTo(3);
    }

    @Test
    void 콜론_구분자_포함() {
        assertThat(new TextCalculator().calculate("1:2")).isEqualTo(3);
    }

    @Test
    void 콜론_쉼표_구분자_포함() {
        assertThat(new TextCalculator().calculate("1,2:3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_포함() {
        assertThat(new TextCalculator().calculate("//;\n1;2,3")).isEqualTo(6);
    }

    @Test
    void 커스텀_구분자_여러개_포함() {
        assertThat(new TextCalculator().calculate("//;.?\n1;2,3.1?1")).isEqualTo(8);
    }

    @Test
    void null_입력() {
        assertThat(new TextCalculator().calculate(null)).isEqualTo(0);
    }

    @Test
    void 빈_문자열_입력() {
        assertThat(new TextCalculator().calculate("")).isEqualTo(0);
    }

    @Test
    void 유효하지_않은_입력() {
        assertThat(new TextCalculator().calculate("//!?\n")).isEqualTo(0);
    }

    @Test
    void 정규표현식_특수_문자_커스텀_구분자() {
        assertThat(new TextCalculator().calculate("//$\n1$2,3")).isEqualTo(6);
    }

    @Test
    void 음수_입력_하나() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("-2");
        });
    }

    @Test
    void 음수_입력_여러개() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("-1,2,3");
        });
    }

    @Test
    void 커스텀_음수_입력() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("//!\n-1!2,3");
        });
    }

    @Test
    void 금지된_커스텀_구분자() {
        assertThrows(IllegalArgumentException.class, () -> {
            new TextCalculator().calculate("//-\n1!2,3");
        });
    }
}

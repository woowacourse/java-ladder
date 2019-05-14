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
}

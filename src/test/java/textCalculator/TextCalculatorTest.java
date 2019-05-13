package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class TextCalculatorTest {
    @Test
    void 숫자만입력() {
        assertThat(new TextCalculator().calculate("1")).isEqualTo(1);
    }
}

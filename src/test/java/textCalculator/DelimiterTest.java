package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTest {
    @Test
    void 커스텀구분자추출하기1() {
        assertThat(new Delimiter().extractCustomDelimiters("//&\n1&2,3"))
                .isEqualTo("1&2,3");
    }

    @Test
    void 커스텀구분자추출하기2() {
        assertThat(new Delimiter().extractCustomDelimiters("1:2,3"))
                .isEqualTo("1:2,3");
    }

    @Test
    void 금지된커스텀구분자포함() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Delimiter().extractCustomDelimiters("//-&\n1&2-3");
        });
    }
}

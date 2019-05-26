package textCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTest {
    @Test
    void 커스텀_구분자_추출() {
        assertThat(new Delimiter().extractCustomDelimiters("//&\n1&2,3"))
                .isEqualTo("1&2,3");
    }

    @Test
    void 디폴트_구분자_계산() {
        assertThat(new Delimiter().extractCustomDelimiters("1:2,3"))
                .isEqualTo("1:2,3");
    }

    @Test
    void 금지된_커스텀_구분자_에러() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Delimiter().extractCustomDelimiters("//-&\n1&2-3");
        });
    }
}

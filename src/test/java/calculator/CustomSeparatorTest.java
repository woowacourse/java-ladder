package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomSeparatorTest {

    @Test
    void 생성자가_숫자일_경우() {
        assertThatThrownBy(() -> new CustomSeparator("12")).isInstanceOf(IllegalArgumentException.class);
    }
}

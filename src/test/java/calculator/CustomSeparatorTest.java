package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CustomSeparatorTest {

    @Test
    void 구분자가_숫자일_경우() {
        assertThatThrownBy(() -> new CustomSeparator("12")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자가_빈칸일_경우(){
        assertThatThrownBy(() -> new CustomSeparator("")).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구분자가_null일_경우(){
        assertThatThrownBy(() -> new CustomSeparator(null)).isInstanceOf(IllegalArgumentException.class);
    }
}

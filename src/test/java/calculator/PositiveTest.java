package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PositiveTest {
    @Test
    void 생성자_테스트() {
        assertThat(new Positive(1).getNumber()).isEqualTo(1);
    }

    @Test
    void 음수값_예외_테스트() {
        assertThatThrownBy(() -> new Positive(-1)).isInstanceOf(RuntimeException.class);
    }
}

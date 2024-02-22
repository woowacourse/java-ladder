package ladder.domain.ladder;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @Test
    @DisplayName("사다리는 높이를 가진다.")
    void testConstruct() {
        int value = 1;
        Height height = new Height(value);
        assertThat(value).isEqualTo(height.getHeight());
    }

    @Test
    @DisplayName("사다리의 높이가 범위를 벗어나면 예외가 발생한다.")
    void testInvalidHeightRange() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

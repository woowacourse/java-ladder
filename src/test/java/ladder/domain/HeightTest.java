package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class HeightTest {

    @DisplayName("높이가 0 이하면 예외가 발생한다.")
    @Test
    void validateMinValue() {
        // when & then
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("높이를 생성한다.")
    @Test
    void createHeight() {
        // when
        Height height = new Height(1);

        // then
        assertThat(height).extracting("value").isEqualTo(1);
    }
}

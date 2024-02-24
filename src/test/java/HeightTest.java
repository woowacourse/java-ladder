import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-10, -5, 0})
    @DisplayName("다리 높이에 0이하의 수를 입력하면 예외가 발생한다.")
    void invalidHeight(int height) {
        assertThatThrownBy(() -> new Height(height)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력보다 높이가 높으면 참을 반환한다.")
    void isBiggerThanTrue() {
        final Height height = new Height(2);
        assertThat(height.isBiggerThan(1)).isTrue();
    }

    @Test
    @DisplayName("입력보다 높이가 높지 않으면 거짓을 반환한다.")
    void isBiggerThanFalse() {
        final Height height = new Height(2);
        assertThat(height.isBiggerThan(2)).isFalse();
    }
}

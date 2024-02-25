import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {
    @Test
    @DisplayName("다리 높이에 0이하의 수를 입력하면 예외가 발생한다.")
    void invalidHeight() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("다리 높이에 0보다 큰 수를 입력하면 정상적으로 다리 높이를 생성한다.")
    void validHeight() {
        assertThatCode(() -> new Height(1)).doesNotThrowAnyException();
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

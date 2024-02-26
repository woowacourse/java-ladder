import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @ParameterizedTest
    @ValueSource(ints = {-10, -5, 0})
    @DisplayName("다리 높이에 0이하의 수를 입력하면 예외를 발생시킨다.")
    void invalidHeight(int height) {
        assertThatThrownBy(() -> new Height(height)).isInstanceOf(IllegalArgumentException.class);
    }
}

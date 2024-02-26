import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {
    @DisplayName("다리 높이에 0이하의 수를 입력하면 예외를 발생시킨다.")
    @Test
    void invalidHeight() {
        assertThatThrownBy(() -> new Height(0)).isInstanceOf(IllegalArgumentException.class);
    }
}

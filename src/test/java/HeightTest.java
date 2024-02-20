import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import domain.Height;

public class HeightTest {

    @Test
    @DisplayName("높이가 1개 미만이면 예외가 발생한다.")
    void lessThanOneExceptionTest() {
        assertThatThrownBy(() -> new Height(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 1개 이상이어야 합니다.");
    }

    @Test
    @DisplayName("높이가 50개 초과면 예외가 발생한다.")
    void moreThanHundredExceptionTest() {
        assertThatThrownBy(() -> new Height(101))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 높이는 100개 이하여야 합니다.");
    }

}

import domain.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static message.ErrorMessage.INVALID_LADDER_HEIGHT_EXCEPTION;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HeightTest {

    @DisplayName("높이 객체를 정상적으로 생성한다.")
    @Test
    void createHeight() {
        assertThat(new Height(5).getHeight()).isEqualTo(5);
    }

    @DisplayName("높이가 0이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createHeightWithUnderZero(int invalidHeight) {
        assertThatThrownBy(() -> new Height(invalidHeight))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_LADDER_HEIGHT_EXCEPTION.getMessage());
    }
}

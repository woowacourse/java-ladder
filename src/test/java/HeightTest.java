import domain.Height;
import domain.Ladder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class HeightTest {

    @DisplayName("높이 객체를 정상적으로 생성한다.")
    @Test
    void createHeight() {
        assertThat(new Height(5))
                .isInstanceOf(Height.class);
    }

    @DisplayName("높이가 0이하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void createHeightWithUnderZero(int invalidHeight) {
        assertThatThrownBy(() -> new Height(invalidHeight))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

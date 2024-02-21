package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class HeightTest {

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "#@#", "", "  "})
    @DisplayName("높이는 양의 정수만 가능하다.")
    void isPositiveIntegerTest() {

        assertThatThrownBy(() -> new Height("0"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

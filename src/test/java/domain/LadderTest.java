package domain;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LadderTest {

    @DisplayName("사다리를 생성한다.")
    @Test
    void create_ladder() {
        assertDoesNotThrow(() -> new Ladder(4, 4, new RandomDigitsGenerator()));
    }

    @DisplayName("사다리 높이가 0 이하인 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    void invalid_height(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, new RandomDigitsGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

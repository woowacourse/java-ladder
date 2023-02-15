package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LadderTest {

    @Test
    @DisplayName("")
    void ladder() {
        new Ladder(4, 4, new RandomDigitsGenerator());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("")
    void invalid_height(int height) {
        assertThatThrownBy(() -> new Ladder(height, 4, new RandomDigitsGenerator()))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

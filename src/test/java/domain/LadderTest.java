package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class LadderTest {

    @Test
    @DisplayName("")
    void ladder() {
        new Ladder(4);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1})
    @DisplayName("")
    void invalid_height(int height) {
        Assertions.assertThatThrownBy(() -> new Ladder(height))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

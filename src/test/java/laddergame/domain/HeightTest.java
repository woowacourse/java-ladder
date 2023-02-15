package laddergame.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


class HeightTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0})
    void throwExceptionWhenValueIsZeroOrNegative(final int value) {
        assertThatThrownBy(() -> new Height(value));
    }

    @Test
    void create() {
        assertDoesNotThrow(() -> new Height(1));
    }
}
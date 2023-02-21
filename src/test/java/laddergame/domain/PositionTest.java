package laddergame.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("위치")
class PositionTest {
    @DisplayName("움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {-5, -4, -3, -2, -1, 1, 2, 3, 4, 5})
    void move(final int value) {
        final Position position = new Position(0);
        final Position movedPosition = position.move(value);
        final int movedPositionValue = movedPosition.getValue();
        final int expectedPosition = position.getValue() + value;

        assertThat(movedPositionValue).isEqualTo(expectedPosition);
    }

    @DisplayName("위치 값을 가져온다.")
    @ParameterizedTest()
    @ValueSource(ints = {1, 2, 3, 4})
    void getValue(final int value) {
        final Position position = new Position(value);

        assertThat(position.getValue()).isEqualTo(value);
    }
}
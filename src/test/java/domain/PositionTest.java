package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("Position은 0보다 작을 수 없다")
    void positionInvalidTest() {
        Position position = new Position(0);
        assertThatThrownBy(position::minus)
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(Position.INVALID_POSITION);
    }

    @Test
    @DisplayName("Position 일치 테스트")
    void positionValidTest() {
        Position position = new Position(0);
        position = position.plus(new Position(2));
        position = position.minus();
        assertThat(position).isEqualTo(new Position(1));
    }
}

package domain;

import domain.result.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("위치를 왼쪽으로 옮긴다.")
    void movePositionLeft() {
        Position position = new Position(10);
        position.movePositionLeft();
        Assertions.assertThat(position.getPosition()).isEqualTo(9);
    }

    @Test
    @DisplayName("위치를 오른쪽으로 옮긴다.")
    void movePositionRight() {
        Position position = new Position(10);
        position.movePositionRight();
        Assertions.assertThat(position.getPosition()).isEqualTo(11);
    }
}

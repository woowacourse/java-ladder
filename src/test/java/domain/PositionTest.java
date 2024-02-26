package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    @DisplayName("Position의 아래 이동을 확인한다.")
    void moveDown() {
        final Position position = new Position(0, 0);

        final int newPosition = position.moveDown();

        assertThat(newPosition).isEqualTo(1);
    }

    @Test
    @DisplayName("Position의 왼쪽 이동을 확인한다.")
    void moveLeft() {
        final Position position = new Position(0, 0);

        final int newPosition = position.moveLeft();

        assertThat(newPosition).isEqualTo(-1);
    }
    @Test
    @DisplayName("Postition의 오른쪽 이동을 확인한다.")
    void moveRight() {
        final Position position = new Position(0, 0);

        final int newPosition = position.moveRight();

        assertThat(newPosition).isEqualTo(1);
    }
}

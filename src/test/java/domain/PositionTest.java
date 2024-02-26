package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class PositionTest {
    @Test
    @DisplayName("Position의 아래 이동을 확인한다.")
    void moveDown() {
        final Position position = new Position(0, 0);

        final int newPosition = position.moveDown();

        assertThat(newPosition).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"true, -1", "false, 0"})
    @DisplayName("Position은 주어진 조건에 따라 왼쪽 이동을 확인한다.")
    void moveLeft(boolean condition, int expectedPosition) {
        final Position position = new Position(0, 0);

        position.moveLeft(condition);

        assertThat(position.getHorizontalLocation()).isEqualTo(expectedPosition);
    }

    @Test
    @DisplayName("Postition의 오른쪽 이동을 확인한다.")
    void moveRight() {
//        final Position position = new Position(0, 0);
//
//        final int newPosition = position.moveRight(hasBridge(position));
//
//        assertThat(newPosition).isEqualTo(1);
    }
}

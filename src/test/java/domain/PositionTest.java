package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    @DisplayName("왼쪽으로 이동한다.")
    void moveLeftTest() {
        Position position = new Position(3);
        position.moveLeft();

        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    @DisplayName("오른쪽으로 이동한다.")
    void moveRightTest() {
        Position position = new Position(3);
        position.moveRight();

        assertThat(position.getPosition()).isEqualTo(4);
    }
}

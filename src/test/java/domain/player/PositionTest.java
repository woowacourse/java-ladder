package domain.player;

import domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("왼쪽으로 한 칸 이동한 후 아래로 한 칸 내려간다.")
    void moveLeftTest() {
        Position position = new Position(3);
        position.moveLeft();
        assertThat(position.getX() + ", " + position.getY())
                .isEqualTo("2, 1");

    }

    @Test
    @DisplayName("오른쪽으로 한 칸 이동한 후 아래로 한 칸 내려간다.")
    void moveRightTest() {
        Position position = new Position(3);
        position.moveRight();
        assertThat(position.getX() + ", " + position.getY())
                .isEqualTo("4, 1");
    }


    @Test
    @DisplayName("아래로만 한 칸 내려간다.")
    void moveDownTest() {
        Position position = new Position(3);
        position.moveDown();
        assertThat(position.getX() + ", " + position.getY())
                .isEqualTo("3, 1");
    }
}
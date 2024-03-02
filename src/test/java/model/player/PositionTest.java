package model.player;

import static model.laddergame.Direction.LEFT;
import static model.laddergame.Direction.RIGHT;

import model.players.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PositionTest {
    @DisplayName("이동 테스트")
    @Nested
    class move {
        @DisplayName("오른쪽으로 성공적으로 이동한다.")
        @Test
        void moveRight() {
            Position position = new Position(1);
            int moved = position.move(RIGHT);
            Assertions.assertThat(moved).isEqualTo(2);
        }

        @DisplayName("왼쪽으로 성공적으로 이동한다.")
        @Test
        void moveLeft() {
            Position position = new Position(3);
            int moved = position.move(LEFT);
            Assertions.assertThat(moved).isEqualTo(2);
        }
    }
}

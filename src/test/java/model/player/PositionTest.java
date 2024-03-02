package model.player;

import static model.ladderGame.Direction.LEFT;
import static model.ladderGame.Direction.RIGHT;

import model.players.Position;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class PositionTest { // TODO: 마지막 위치여서 혹은 첫번째 위치여서 오른쪽, 왼쪽으로 이동하지 못하는 테스트 추가
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

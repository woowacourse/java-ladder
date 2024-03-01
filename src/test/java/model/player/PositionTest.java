package model.player;

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
            Position actual = position.moveRight();
            Assertions.assertThat(actual).isEqualTo(new Position(2));
        }

        @DisplayName("마지막 위치여서 오른쪽으로 이동하는 것에 실패한다.")
        @Test
        void moveLeft() {
            Position position = new Position(3);
            Position actual = position.moveLeft();
            Assertions.assertThat(actual).isEqualTo(new Position(2));
        }
    }
}

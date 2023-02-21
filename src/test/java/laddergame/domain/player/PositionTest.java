package laddergame.domain.player;

import laddergame.domain.player.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {

    @Test
    @DisplayName("오른쪽으로 이동하는 메서드를 실행시키면 오른쪽으로 한 칸 이동된다.")
    void whenMoveRight_thenReturnPlusOnePosition() {
        // given
        final Position position = Position.from(0);

        // when
        position.moveRight();

        // then
        assertThat(position.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("왼쪽으로 이동하는 메서드를 실행시키면 왼쪽으로 한 칸 이동된다.")
    void whenMoveLeft_thenReturnMinusOnePosition() {
        // given
        final Position position = Position.from(1);

        // when
        position.moveLeft();

        // then
        assertThat(position.getPosition()).isEqualTo(0);
    }
}

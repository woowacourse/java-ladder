package laddergame.domain;

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
}

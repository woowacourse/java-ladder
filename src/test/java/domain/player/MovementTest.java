package domain.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MovementTest {

    @DisplayName("움직인 방향에 따른 새로운 위치를 알려줄 수 있다.")
    @Test
    void moveTest() {
        assertThat(Movement.GO_RIGHT.move(new Position(0))).isEqualTo(new Position(1));
        assertThat(Movement.GO_LEFT.move(new Position(1))).isEqualTo(new Position(0));
        assertThat(Movement.STAY.move(new Position(2))).isEqualTo(new Position(2));
    }

}

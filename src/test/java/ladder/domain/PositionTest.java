package ladder.domain;

import ladder.domain.player.Position;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PositionTest {

    @Test
    void 왼쪽으로_이동_테스트() {
        Position position = new Position(3);
        position.moveLeft();

        assertThat(position.getPosition()).isEqualTo(2);
    }

    @Test
    void 오른쪽으로_이동_테스트() {
        Position position = new Position(3);
        position.moveRight();

        assertThat(position.getPosition()).isEqualTo(4);
    }
}

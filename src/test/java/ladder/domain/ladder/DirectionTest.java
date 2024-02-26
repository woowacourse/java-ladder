package ladder.domain.ladder;

import ladder.domain.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static ladder.domain.ladder.Direction.*;
import static org.assertj.core.api.Assertions.assertThat;

class DirectionTest {
    @Test
    @DisplayName("특정 방향으로 움직인 Position 값을 올바르게 반환")
    void determineNextPositionTest() {
        // given
        Position position = new Position(1);

        // when
        Position leftPosition = LEFT.determineNextPosition(position);
        Position rightPosition = RIGHT.determineNextPosition(position);
        Position neutralPosition = NEUTRAL.determineNextPosition(position);

        // then
        assertThat(leftPosition).isEqualTo(new Position(0));
        assertThat(rightPosition).isEqualTo(new Position(2));
        assertThat(neutralPosition).isEqualTo(position);
    }
}

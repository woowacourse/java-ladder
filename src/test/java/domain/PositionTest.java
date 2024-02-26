package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {
    @Test
    @DisplayName("Position이 사다리의 다음 라인으로 넘어가는지 확인한다.")
    void next() {
        final Position position = new Position(0, 0);

        final int newPosition = position.moveDown();

        assertThat(newPosition).isEqualTo(1);
    }
}

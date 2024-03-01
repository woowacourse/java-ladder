package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PositionTest {

    @Test
    @DisplayName("올바르게 움직이는지 확인한다")
    void moveHorizontally() {
        final Line line = new Line(List.of(Bridge.BRIDGE));
        final Position position = new Position(0);

        position.moveHorizontally(line);

        assertThat(position.getValue()).isEqualTo(1);
    }

}

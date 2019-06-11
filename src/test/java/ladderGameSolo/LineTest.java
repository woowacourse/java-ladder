package ladderGameSolo;

import ladderGameSolo.domain.Direction;
import ladderGameSolo.domain.Line;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LineTest {
    @Test
    void 포지션_초기화() {
        Line line = new Line(4);
        assertThat(line.getDirectionByIndex(2)).isEqualTo(new Direction(false, false));
    }
}

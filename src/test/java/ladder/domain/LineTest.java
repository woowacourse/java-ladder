package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @DisplayName("라인에서 움직일 방향을 표현한다.")
    @Test
    void lineTest() {
        Line line1 = new Line(4, () -> RIGHT);
        Line line2 = new Line(4, () -> NONE);

        assertAll(
                () -> assertThat(line1.getDirectionAt(0)).isEqualTo(RIGHT),
                () -> assertThat(line1.getDirectionAt(1)).isEqualTo(LEFT),
                () -> assertThat(line1.getDirectionAt(2)).isEqualTo(RIGHT),
                () -> assertThat(line1.getDirectionAt(3)).isEqualTo(LEFT),

                () -> assertThat(line2.getDirectionAt(0)).isEqualTo(NONE),
                () -> assertThat(line2.getDirectionAt(1)).isEqualTo(NONE),
                () -> assertThat(line2.getDirectionAt(2)).isEqualTo(NONE),
                () -> assertThat(line2.getDirectionAt(3)).isEqualTo(NONE)
        );
    }
}

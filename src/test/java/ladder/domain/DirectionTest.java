package ladder.domain;

import static ladder.domain.Direction.LEFT;
import static ladder.domain.Direction.NONE;
import static ladder.domain.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DirectionTest {
    @DisplayName("RIGHT 다음은 무조건 LEFT이다.")
    @Test
    void nextTest() {
        assertAll(
                () -> assertThat(RIGHT.next(() -> RIGHT)).isEqualTo(LEFT),
                () -> assertThat(RIGHT.next(() -> NONE)).isEqualTo(LEFT)
        );
    }
}

package ladder.domain;

import static ladder.domain.ladder.Direction.LEFT;
import static ladder.domain.ladder.Direction.NONE;
import static ladder.domain.ladder.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import ladder.domain.ladder.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class DirectionTest {
    @DisplayName("RIGHT 다음은 무조건 LEFT이다.")
    @EnumSource(Direction.class)
    @ParameterizedTest
    void nextTest(Direction direction) {
        assertThat(RIGHT.next(() -> direction)).isEqualTo(LEFT);
    }

    @DisplayName("마지막이 RIGHT이면 invalid이다.")
    @Test
    void isInvalidLastTest() {
        assertAll(
                () -> assertThat(RIGHT.isInvalidLast()).isTrue(),
                () -> assertThat(LEFT.isInvalidLast()).isFalse(),
                () -> assertThat(NONE.isInvalidLast()).isFalse()
        );
    }
}

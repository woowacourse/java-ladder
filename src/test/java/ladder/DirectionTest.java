package ladder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {

    @Test
    @DisplayName("점의 방향에 따라 인덱스를 올바르게 계산한다.")
    void indexCalculateTest() {
        // given
        Index index = Index.of(1);
        // when, then
        assertThat(Direction.STRAIGHT.apply(index)).isEqualTo(Index.of(1));
        assertThat(Direction.LEFT.apply(index)).isEqualTo(Index.of(0));
        assertThat(Direction.RIGHT.apply(index)).isEqualTo(Index.of(2));
    }
}

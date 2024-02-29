package ladder;

import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;
import static org.assertj.core.api.Assertions.assertThat;

import org.assertj.core.api.Assertions;
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

    @Test
    @DisplayName("이전 방향이 오른쪽이라면, 반드시 왼쪽을 반환한다.")
    void generateLeftAfterRight() {
        // when
        Direction actual = RIGHT.next(true);
        // then
        Assertions.assertThat(actual).isEqualTo(LEFT);
    }

    @Test
    @DisplayName("이전 방향이 오른쪽이 아닐 때, 오른쪽으로 잇고자 한다면 오른쪽을 반환한다.")
    void generateRight() {
        // when
        Direction actual = LEFT.next(true);
        // then
        Assertions.assertThat(actual).isEqualTo(RIGHT);
    }

    @Test
    @DisplayName("마지막 방향을 올바르게 반환한다.")
    void generateLastDirection() {
        // when
        Direction actual = RIGHT.nextAsLast();
        // then
        Assertions.assertThat(actual).isEqualTo(LEFT);
    }
}

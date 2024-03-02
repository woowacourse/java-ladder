package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DirectionTest {
    @Test
    @DisplayName("생성된 첫 방향은 왼쪽이 될 수 없다")
    void generateFirst() {
        assertThat(Direction.generateFirst(PointState.EMPTY)).isNotEqualTo(Direction.LEFT);
        assertThat(Direction.generateFirst(PointState.CONNECT_NEXT_POINT)).isNotEqualTo(Direction.LEFT);
    }

    @Test
    @DisplayName("생성된 마지막 방향은 오른쪽이 될 수 없다")
    void generateLast() {
        assertAll(
                () -> assertThat(Direction.generateLast(Direction.RIGHT)).isNotEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generateLast(Direction.LEFT)).isNotEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generateLast(Direction.STRAIGHT)).isNotEqualTo(Direction.RIGHT)
        );
    }

    @Test
    @DisplayName("이전 방향에 따라 현재 방향이 결정 된다")
    void generate() {
        assertAll(
                () -> assertThat(Direction.generate(Direction.RIGHT, PointState.CONNECT_NEXT_POINT))
                        .isEqualTo(Direction.LEFT),
                () -> assertThat(Direction.generate(Direction.RIGHT, PointState.EMPTY))
                        .isEqualTo(Direction.LEFT),

                () -> assertThat(Direction.generate(Direction.LEFT, PointState.CONNECT_NEXT_POINT))
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generate(Direction.LEFT, PointState.EMPTY))
                        .isEqualTo(Direction.STRAIGHT),

                () -> assertThat(Direction.generate(Direction.STRAIGHT, PointState.CONNECT_NEXT_POINT))
                        .isEqualTo(Direction.RIGHT),
                () -> assertThat(Direction.generate(Direction.STRAIGHT, PointState.EMPTY))
                        .isEqualTo(Direction.STRAIGHT)
        );
    }
}

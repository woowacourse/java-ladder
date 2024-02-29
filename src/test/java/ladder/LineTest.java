package ladder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("한 줄의 정보가 주어지면, 올바르게 생성한다.")
    void creationTest() {
        Assertions.assertDoesNotThrow(() ->
                new Line(
                        new Point(Direction.RIGHT),
                        new Point(Direction.LEFT))
        );
    }

    @Test
    @DisplayName("인덱스가 주어지면, 목표 인덱스를 정확하게 반환한다.")
    void lineIndexMoveTest() {
        // given
        Line line = new Line(
                new Point(Direction.RIGHT),
                new Point(Direction.LEFT),
                new Point(Direction.RIGHT),
                new Point(Direction.LEFT)
        );
        // when, then
        assertThat(line.move(0)).isEqualTo(1);
        assertThat(line.move(3)).isEqualTo(2);
    }

    @Test
    @DisplayName("범위를 벗어나는 경우, 예외를 발생한다")
    void invalidIndexTest() {
        // given
        Line line = new Line(
                new Point(Direction.RIGHT),
                new Point(Direction.LEFT),
                new Point(Direction.STRAIGHT)
        );
        // when, then
        assertThatThrownBy(() -> line.move(5))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    @DisplayName("양 쪽으로 연결되는 경우, 예외를 발생한다.")
    void invalidCreationTest() {
        // given
        Point point = new Point(Direction.RIGHT);
        // when, then
        assertThatThrownBy(() -> new Line(point, point))
                .isInstanceOf(IllegalArgumentException.class);
    }
}

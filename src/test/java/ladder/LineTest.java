package ladder;

import static ladder.Direction.LEFT;
import static ladder.Direction.RIGHT;
import static ladder.Direction.STRAIGHT;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {

    @Test
    @DisplayName("한 줄의 정보가 주어지면, 올바르게 생성한다.")
    void creationTest() {
        assertDoesNotThrow(() -> {
            List<Direction> directions = List.of(RIGHT, LEFT, STRAIGHT, STRAIGHT);
            return new Line(directions);
        });
    }

    @Test
    @DisplayName("인덱스가 주어지면, 목표 인덱스를 정확하게 반환한다.")
    void lineIndexMoveTest() {
        // given
        List<Direction> directions = List.of(RIGHT, LEFT, RIGHT, LEFT);
        Line line = new Line(directions);
        // when, then
        assertThat(line.move(Index.of(0))).isEqualTo(Index.of(1));
        assertThat(line.move(Index.of(3))).isEqualTo(Index.of(2));
    }

    @Test
    @DisplayName("범위를 벗어나는 경우, 예외를 발생한다")
    void invalidIndexTest() {
        // given
        List<Direction> directions = List.of(RIGHT, LEFT, STRAIGHT);
        Line line = new Line(directions);
        Index index = Index.of(5);
        // when, then
        assertThatThrownBy(() -> line.move(index))
                .isInstanceOf(IndexOutOfBoundsException.class)
                .hasMessage("인덱스를 벗어납니다.");
    }

    @Test
    @DisplayName("양 쪽으로 연결되는 경우, 예외를 발생한다.")
    void invalidCreationTest() {
        List<Direction> directions = List.of(RIGHT, RIGHT);
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사다리 연결입니다.");
    }

    @Test
    @DisplayName("가장 왼쪽이나 오른쪽에 올바르지 않은 연결이 들어오면 예외를 발생한다.")
    void invalidCreationWhenSideContainsIllegalDirection() {
        List<Direction> invalidLeftDirections = List.of(LEFT, STRAIGHT, STRAIGHT);
        List<Direction> invalidRightDirections = List.of(STRAIGHT, STRAIGHT, RIGHT);

        assertThatThrownBy(() -> new Line(invalidLeftDirections))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사다리 연결입니다.");

        assertThatThrownBy(() -> new Line(invalidRightDirections))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("잘못된 사다리 연결입니다.");
    }

    @Test
    @DisplayName("두 개 미만의 방향이 주어지면 예외를 발생한다.")
    void invalidCreationOnSmallSize() {
        List<Direction> directions = List.of(STRAIGHT);
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바르지 않은 방향의 개수입니다.");
    }

    @Test
    @DisplayName("항상 놓는 전략을 사용하는 경우, 올바르게 한 줄을 생성한다.")
    void creationOnAlwaysSuppliesTrue() {
        // given
        Line line = Line.fromConnectionAttemptSupplier(() -> true, 5);
        // when
        List<Direction> expected = List.of(RIGHT, LEFT, RIGHT, LEFT, STRAIGHT);
        // then
        assertThat(line.getDirections()).containsExactlyElementsOf(expected);
    }
}

package ladder.domain.resource.line;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LineTest {

    @DisplayName("방향의 수가 2~10이 아닐 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 11})
    void newLineByOutOfSize(int count) {
        //given
        List<Direction> directions = generateDirections(count);

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 방향은 2~10개 까지만 등록 가능합니다.");
    }

    @DisplayName("첫번째 방향이 '왼쪽'일 경우 예외가 발생한다.")
    @Test
    void newLineByFirstDirection() {
        //given
        List<Direction> directions = List.of(
                Direction.LEFT,
                Direction.NEUTRAL
        );

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 첫번째 방향에는 '왼쪽'이 올 수 없습니다.");
    }

    @DisplayName("이전 방향이 '오른쪽'일 때, 다음 값이 '왼쪽'이 아닐 경우 예외가 발생한다.")
    @Test
    void newLineByNotLeftAfterRight() {
        //given
        List<Direction> directions = List.of(
                Direction.RIGHT,
                Direction.RIGHT,
                Direction.LEFT
        );

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이전 방향이 '오른쪽'일 경우 다음 방향으로 '왼쪽'이 와야 합니다.");
    }

    @DisplayName("이전 방향이 '오른쪽'이 아닐 때, 다음 값이 '왼쪽'일 경우 예외가 발생한다.")
    @Test
    void newLineByLeftAfterNotRight() {
        //given
        List<Direction> directions = List.of(
                Direction.NEUTRAL,
                Direction.LEFT,
                Direction.NEUTRAL
        );

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이전 방향이 '오른쪽'이 아닐 경우 다음 방향으로 '왼쪽'이 올 수 없습니다.");
    }

    @DisplayName("이전 방향이 '오른쪽'일 때, 마지막 값이 '왼쪽'이 아닐 경우 예외가 발생한다.")
    @Test
    void newLineByNotLastLeftAfterRight() {
        //given
        List<Direction> directions = List.of(
                Direction.NEUTRAL,
                Direction.RIGHT,
                Direction.NEUTRAL
        );

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이전 방향이 '오른쪽'일 경우 마지막 방향으로 '왼쪽'이 와야 합니다.");
    }

    @DisplayName("이전 방향이 '오른쪽'이 아닐 때, 마지막 값이 '중립'이 아닐 경우 예외가 발생한다.")
    @Test
    void newLineByNotLastNeutralAfterRight() {
        //given
        List<Direction> directions = List.of(
                Direction.NEUTRAL,
                Direction.NEUTRAL,
                Direction.LEFT
        );

        //when, then
        assertThatThrownBy(() -> new Line(directions))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 이전 방향이 '오른쪽'이 아닐 경우 마지막 방향으로 '중립'이 와야 합니다.");
    }

    @DisplayName("index값에 해당하는 방향을 반환한다.")
    @Test
    void getDirectionByIndex() {
        //given
        List<Direction> directions = generateDirections(2);
        Line line = new Line(directions);

        //when
        Direction directionByIndex = line.getDirectionByIndex(0);

        //then
        assertThat(directionByIndex).isEqualTo(Direction.NEUTRAL);
    }

    @DisplayName("Line의 크기를 반환한다.")
    @Test
    void getSize() {
        //given
        List<Direction> directions = generateDirections(2);
        Line line = new Line(directions);

        //when
        int lineSize = line.getSize();

        //then
        assertThat(lineSize).isEqualTo(2);
    }

    private List<Direction> generateDirections(int count) {
        List<Direction> directions = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            directions.add(Direction.NEUTRAL);
        }

        return directions;
    }
}

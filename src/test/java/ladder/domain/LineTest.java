package ladder.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

public class LineTest {

    @DisplayName("사다리 너비가 참여자 수와 같지 않으면 예외가 발생한다.")
    @Test
    void validateWidth() {
        // when & then
        assertThatThrownBy(() -> new Line(5, Direction.RIGHT, Direction.LEFT, Direction.RIGHT, Direction.LEFT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 시작 좌표가 왼쪽 방향이면 예외가 발생한다.")
    @Test
    void validateStartDirection() {
        // when & then
        assertThatThrownBy(() -> new Line(4, Direction.LEFT, Direction.DOWN, Direction.RIGHT, Direction.LEFT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 끝 좌표가 오른쪽 방향이면 예외가 발생한다.")
    @Test
    void validateEndDirection() {
        // when & then
        assertThatThrownBy(() -> new Line(4, Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.RIGHT))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 모든 좌표가 아래 방향이면 예외가 발생한다.")
    @Test
    void validateNotOnlyDownDirection() {
        // when & then
        assertThatThrownBy(() -> new Line(4, Direction.DOWN, Direction.DOWN, Direction.DOWN, Direction.DOWN))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("라인의 좌표 간 방향이 일관되지 않으면 예외가 발생한다.")
    @Test
    void validateNoMismatchedDirections() {
        // when & then
        assertAll(
                () -> assertThatThrownBy(() -> new Line(4, Direction.DOWN, Direction.RIGHT, Direction.RIGHT, Direction.DOWN))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Line(4, Direction.DOWN, Direction.LEFT, Direction.LEFT, Direction.DOWN))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatThrownBy(() -> new Line(4, Direction.DOWN, Direction.LEFT, Direction.RIGHT, Direction.LEFT))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("방향에 따라 이동한다.")
    @ParameterizedTest
    @CsvSource(value = {"0, 1", "1, 0", "2, 2"})
    void move(int indexValue, int actual) {
        // given
        Line line = new Line(4, Direction.RIGHT, Direction.LEFT, Direction.DOWN, Direction.DOWN);
        Index index = new Index(indexValue);

        // when
        Index expected = line.move(index);

        // then
        assertThat(expected.getValue()).isEqualTo(actual);
    }
}

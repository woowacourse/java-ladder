package domain;

import static domain.Direction.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {
    @Test
    @DisplayName("첫번째 지점에서 왼쪽으로 연결 됐을 때 예외가 발생한다")
    void firstPoint() {
        assertThatCode(() -> Line.ofDirections(LEFT)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 지점에서 오른쪽으로 연결 됐을 때 예외가 발생한다")
    void lastPoint() {
        assertThatCode(() -> Line.ofDirections(RIGHT)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,1"})
    @DisplayName("선택된 점은 연결된 가로선에 따라 움직인다")
    void move(final int startPosition, final int expected) {
        Index startIndex = new Index(startPosition);
        Index expectedIndex = new Index(expected);
        final Line line = Line.ofDirections(STRAIGHT, RIGHT, LEFT);

        final Index actual = line.move(startIndex);

        assertThat(actual).isEqualTo(expectedIndex);
    }

    @Test
    @DisplayName("두 세로선에서 한쪽만 연결되어 있으면 예외가 발생한다")
    void oneConnection() {
        assertAll(
                () -> assertThatCode(() -> Line.ofDirections(RIGHT, STRAIGHT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatCode(() -> Line.ofDirections(STRAIGHT, LEFT))
                        .isInstanceOf(IllegalArgumentException.class),
                () -> assertThatCode(() -> Line.ofDirections(STRAIGHT, LEFT, RIGHT, STRAIGHT))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
}

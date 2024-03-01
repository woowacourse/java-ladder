package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LineTest {
    @Test
    @DisplayName("첫번째 지점에서 왼쪽으로 연결 됐을 때 예외가 발생한다")
    void firstPoint() {
        assertThatCode(() -> new Line(new Point(Direction.LEFT)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("마지막 지점에서 오른쪽으로 연결 됐을 때 예외가 발생한다")
    void lastPoint() {
        assertThatCode(() -> new Line(new Point(Direction.RIGHT))).isInstanceOf(
                IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,2", "2,1"})
    @DisplayName("선택된 점은 연결된 가로선에 따라 움직인다")
    void move(final int startPosition, final int expected) {
        final Line line = new Line(
                new Point(Direction.STRAIGHT), new Point(Direction.RIGHT), new Point(Direction.LEFT)
        );

        final Index actual = line.move(new Index(startPosition));

        assertThat(actual).isEqualTo(new Index(expected));
    }

//    TODO: 한쪽만 연결될 수 없다( Point(false,true), Point(false,false) )
}

package domain;

import domain.ladder.common.Direction;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.params.provider.Arguments.arguments;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

public class PointTest {
    @Test
    @DisplayName("세로 좌표와 가로 좌표를 받아 포인트를 만든다")
    public void createPoint() {
        int row = 3;
        int column = 4;

        assertThatCode(() -> {
            Point point = new Point(row, column);
            assertPoint(point, row, column);
        }).doesNotThrowAnyException();
    }

    @Test
    @DisplayName("빌더를 통해서도 포인트를 만들수 있다.")
    public void createPointWithBuilder() {
        int row = 3;
        int column = 4;

        assertThatCode(() -> {
            Point point = new Point.Builder().row(row)
                                             .column(column)
                                             .build();
            assertPoint(point, row, column);
        });
    }

    private static Stream<Arguments> pointMaskingParam() {
        return Stream.of(
                arguments(3, 4, Direction.DOWN, 3, 5),
                arguments(2, 1, Direction.LEFT, 1, 2),
                arguments(5, 5, Direction.RIGHT, 6, 6)
        );
    }

    @ParameterizedTest(name = "방향에 따라 이동한다. {0},{1} 좌표는 {2}으로 이동하면 {3},{4} 가 된다.")
    @MethodSource("pointMaskingParam")
    public void moveWithDirection(int row, int column, Direction direction, int movedRow, int movedColumn) {
        Point point = new Point.Builder().row(row)
                                         .column(column)
                                         .build();

        Point movedPoint = point.move(direction);

        assertPoint(movedPoint, movedRow, movedColumn);
    }

    private void assertPoint(Point point, int row, int column) {
        assertAll(() -> {
            assertEquals(point.getColumn(), column);
            assertEquals(point.getRow(), row);
        });
    }
}

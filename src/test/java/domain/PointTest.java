package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    private void assertPoint(Point point, int row, int column) {
        assertAll(() -> {
            assertEquals(point.getColumn(), column);
            assertEquals(point.getRow(), row);
        });
    }
}

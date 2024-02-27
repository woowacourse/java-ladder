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
            assertEquals(point.row, row);
            assertEquals(point.column, column);
        }).doesNotThrowAnyException();

    }
}

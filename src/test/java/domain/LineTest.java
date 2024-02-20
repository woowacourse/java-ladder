package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineTest {
    @Test
    @DisplayName("가로 라인은 겹치지 않아야 한다.")
    void isLineCannotNextToLine() {
        int personCount = 5;
        Line line = new Line(personCount);
        boolean isNotNextToLine = true;
        List<Boolean> points = line.getPoints();
        Boolean prevPoint = points.get(0);
        for (Boolean point : points.subList(1, points.size())) {
            if (prevPoint && point) {
                isNotNextToLine = false;
            }
            prevPoint = point;
        }
        assertEquals(true, isNotNextToLine);
    }
}

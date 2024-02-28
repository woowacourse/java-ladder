package domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LineTest {
    @Test
    @DisplayName("가로 라인은 겹치지 않아야 한다.")
    void isLineCannotNextToLine() {
        int personCount = 5;
        Line line = new Line(personCount, new RandomPointGenerator());
        List<Boolean> points = line.getMovableLinePoints();
        int isInvalidLine = Collections.indexOfSubList(points, List.of(true, true));

        assertEquals(-1, isInvalidLine);
    }
}

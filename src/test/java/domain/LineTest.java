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
        Line line = new Line(personCount, new FixedBooleanGenerator());
        List<Boolean> points = line.getPoints();
        int isInvalidLine = Collections.indexOfSubList(points, List.of(true, true));

        assertEquals(-1, isInvalidLine);
    }
}

class FixedBooleanGenerator implements BooleanGenerator {
    @Override
    public Boolean generate() {
        return true;
    }
}

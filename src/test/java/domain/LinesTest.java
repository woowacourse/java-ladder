package domain;

import domain.lines.Lines;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinesTest {
    @Test
    @DisplayName("높이 값 만큼 Line을 생성한다.")
    void createLines() {
        int height = 5;
        int personCount = 4;
        Lines lines = new Lines(height, personCount);

        assertEquals(height, lines.getLines().size());
    }
}

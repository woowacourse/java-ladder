package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinesTest {
    @Test
    @DisplayName("높이 값 만큼 Line을 생성한다.")
    void createLines() {
        int height = 5;
        int personCount = 4;
        LineGenerator lineGenerator = new LineGenerator(personCount, new RandomBooleanGenerator());
        Lines lines = new Lines(height, lineGenerator);

        assertEquals(height, lines.getLines().size());
    }
}

package domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LineGenerator;
import util.RandomLineGenerator;

class LinesTest {

    @Test
    @DisplayName("Lines 객체 생성 확인")
    void createLines() {
        int numberOfWalls = 5;
        Height height = new Height(6);
        LineGenerator lineGenerator = new RandomLineGenerator();

        Lines lines = new Lines(numberOfWalls, height, lineGenerator);

        assertThat(lines.getLines().size()).isEqualTo(6);
    }
}
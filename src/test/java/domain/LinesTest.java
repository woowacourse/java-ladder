package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.LineGenerator;
import util.LineStatusMaker;

import static org.assertj.core.api.Assertions.assertThat;

public class LinesTest {

    @Test
    @DisplayName("Lines 객체가 정상적으로 생성되는지 확인")
    void makeLines() {
        int numberOfWalls = 4;
        Height height = new Height(5);
        LineGenerator lineGenerator = new LineStatusMaker();

        Lines lines = new Lines(numberOfWalls, height, lineGenerator);

        assertThat(lines.getLines().size()).isEqualTo(height.getHeight());
    }
}

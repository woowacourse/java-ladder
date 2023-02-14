package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import utils.LineGenerator;

public class LineGeneratorTest {

    @Test
    @DisplayName("이전 사다리가 true면 false")
    void lineGenerateTest() {
        Line line = new Line(List.of(true, true, true));
        Line newLine = LineGenerator.generate(line);

        assertThat(newLine.getExistedLine()).containsExactly(false, false, false);
    }
}

package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;
import org.junit.jupiter.api.Test;

class LinesTest {

    @Test
    void 모두_false_인_경우_빈_lines_가_반환된다() {
        Lines lines = new Lines(2, 2);
        lines.generateLegsOfLines(new MockGenerator(false));

        for (Line line : lines.getLines()) {
            assertThat(line.getByHeight(0)).isFalse();
            assertThat(line.getByHeight(1)).isFalse();
        }
    }

    @Test
    void 모두_true_인_경우_가능한_많은_사다리가_그려진다() {
        Lines lines = new Lines(2, 3);
        lines.generateLegsOfLines(new MockGenerator(true));

        List<Line> lineList = lines.getLines();
        assertAll(
                () -> assertThat(lineList.get(0).getByHeight(0)).isTrue(),
                () -> assertThat(lineList.get(0).getByHeight(1)).isTrue(),
                () -> assertThat(lineList.get(1).getByHeight(0)).isFalse(),
                () -> assertThat(lineList.get(1).getByHeight(1)).isFalse()
        );
    }
}
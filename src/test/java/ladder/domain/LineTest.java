package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {
    private Line line;
    private Record record;

    @BeforeEach
    void setUp() {
        record = new Record(new ArrayList<>(Arrays.asList(0, 1, 2)));
    }

    @Test
    void 움직임_테스트_false_false() {
        line = new Line(new ArrayList<>(Arrays.asList(false, false)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(0, 1, 2)));
    }

    @Test
    void 움직임_테스트_true_true() {
        line = new Line(new ArrayList<>(Arrays.asList(true, true)));
        assertThrows(IllegalArgumentException.class, () -> line.drawLine(record));
    }

    @Test
    void 움직임_테스트_true_false() {
        line = new Line(new ArrayList<>(Arrays.asList(true, false)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(1, 0, 2)));
    }

    @Test
    void 움직임_테스트_false_true() {
        line = new Line(new ArrayList<>(Arrays.asList(false, true)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<>(Arrays.asList(0, 2, 1)));
    }

    @Test
    void 라인_출력_테스트() {
        line = new Line(new ArrayList<>(Arrays.asList(false, true)));
        assertThat(line.toString()).isEqualTo("|     |-----|");
    }

}

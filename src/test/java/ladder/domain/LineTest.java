package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LineTest {

    ArrayList<Boolean> booleans;
    Line line;
    Record record;

    @BeforeEach
    void setUp() {
        record = new Record(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
    }

    @Test
    void 움직임_테스트_false_false() {
        line = new Line(new ArrayList<Boolean>(Arrays.asList(false, false)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<Integer>(Arrays.asList(0, 1, 2)));
    }

    @Test
    void 움직임_테스트_true_true() {
        line = new Line(new ArrayList<Boolean>(Arrays.asList(true, true)));
        assertThrows(IllegalArgumentException.class, () -> line.drawLine(record));
    }

    @Test
    void 움직임_테스트_true_false() {
        line = new Line(new ArrayList<Boolean>(Arrays.asList(true, false)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<Integer>(Arrays.asList(1, 0, 2)));
    }

    @Test
    void 움직임_테스트_false_true() {
        line = new Line(new ArrayList<Boolean>(Arrays.asList(false, true)));
        assertThat(line.drawLine(record).getIndices()).isEqualTo(new ArrayList<Integer>(Arrays.asList(0, 2, 1)));
    }
}

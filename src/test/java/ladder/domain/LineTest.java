package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private List<Direction> answerLine;

    @BeforeEach
    void setUp() {
        Direction false_false = new Direction(false, false);
        Direction false_true = new Direction(false, true);
        Direction true_false = new Direction(true, false);
        answerLine = new ArrayList<>(Arrays.asList(false_true, true_false, false_false));
    }

    @Test
    void create_Line() {
        Line line = new Line(3);
        line.createLine(new AlwaysTrue());
        assertThat(line.getLine()).isEqualTo(answerLine);
    }
}
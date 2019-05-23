package ladder.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LineTest {
    private List<Direction> answerLine;

    @BeforeEach
    void setUp() {
        DirectionTest directionTest = new DirectionTest();
        answerLine = new ArrayList<>();
        answerLine.add(directionTest.falseTrue);
        answerLine.add(directionTest.trueFalse);
        answerLine.add(directionTest.falseFalse);
    }

    @Test
    void create_Line() {
        Line line = new Line(new AlwaysTrue(), 3);
        assertThat(line.getLine()).isEqualTo(answerLine);
    }
}
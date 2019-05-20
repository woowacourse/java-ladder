package laddergame.domain;

import laddergame.controller.LadderGenerator;
import laddergame.controller.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {
    @Test
    void 라인이_제대로_추가되었는지_확인() {
        int height = 5;
        Ladder ladder = LadderGenerator.generateLadder(height, 2, new AlwaysCreateRule());
        Line line = new Line(Arrays.asList(Point.RIGHT, Point.LEFT));
        List<Line> lines = new ArrayList<>(Arrays.asList(line, line, line, line, line));

        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
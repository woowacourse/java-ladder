package laddergame.domain;

import laddergame.controller.LadderGenerator;
import laddergame.controller.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LadderTest {
    @Test
    void 라인이_제대로_추가되는지_확인() {
        Ladder ladder = new Ladder();
        Line line = new Line(Arrays.asList(Point.RIGHT, Point.LEFT));

        assertThat(ladder.addLines(line)).isTrue();
    }

    @Test
    void 사다리를_타고_제대로_내려가는지_확인() {
        Ladder ladder = LadderGenerator.generateLadder(5, 2, new AlwaysCreateRule());

        assertThat(ladder.takeLadder(0)).isEqualTo(1);
        assertThat(ladder.takeLadder(1)).isEqualTo(0);
    }
}
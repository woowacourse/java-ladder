package laddergame.domain;

import laddergame.domain.rule.AlwaysCreateRule;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {
    @Test
    void 라인이_제대로_추가되었는지_확인() {
        Ladder ladder = LadderGenerator.generateLadder(2, 5, new AlwaysCreateRule());
        Line line = new Line(new ArrayList<>(Arrays.asList(false, true, false)));
        List<Line> lines = new ArrayList<>(Arrays.asList(line, line, line, line, line));

        assertThat(ladder).isEqualTo(new Ladder(lines));
    }
}
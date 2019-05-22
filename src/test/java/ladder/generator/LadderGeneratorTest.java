package ladder.generator;

import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Point;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGeneratorTest {

    @Test
    void 사다리_제네레이터_생성_테스트() {
        Line line = new Line(Arrays.asList(new Point(false, 0, true),
                new Point(true, 1, false),
                new Point(false, 2, false),
                new Point(false, 3, true),
                new Point(true, 4, false),
                new Point(false, 5, false)));
        CustomLineGenerator customLineGenerator = new CustomLineGenerator(line);
        LadderGenerator.makeLadder(5, 6, customLineGenerator);

        List<Line> lines = Arrays.asList(line, line, line, line, line, line);

        assertThat(LadderGenerator.makeLadder(5, 6, customLineGenerator)).isEqualTo(new Ladder(lines));
    }
}
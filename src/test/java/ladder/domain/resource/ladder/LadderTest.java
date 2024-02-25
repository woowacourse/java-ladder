package ladder.domain.resource.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.resource.direction.DirectionGeneratorImpl;
import ladder.domain.resource.line.Line;
import ladder.domain.resource.line.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 라인의 개수가 1개를 미만일 경우 예외가 발생한다.")
    @Test
    void newLadderTestByUnderSize() {
        //given
        List<Line> lines = new ArrayList<>();

        //when, then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 높이는 1~50만 가능합니다.");
    }

    @DisplayName("사다리의 라인의 개수가 50개를 초과할 경우 예외가 발생한다.")
    @Test
    void newLadderTestByOverSize() {
        //given
        int lineCount = 51;
        int width = 5;
        List<Line> lines = new ArrayList<>();
        LineGenerator lineGenerator = new LineGenerator(new DirectionGeneratorImpl());
        for (int i = 0; i < lineCount; i++) {
            lines.add(lineGenerator.generate(width));
        }

        //when, then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 높이는 1~50만 가능합니다.");
    }
}

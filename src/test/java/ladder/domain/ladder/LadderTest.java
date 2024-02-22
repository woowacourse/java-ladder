package ladder.domain.ladder;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import ladder.domain.direction.DirectionGeneratorImpl;
import ladder.domain.line.Line;
import ladder.domain.line.LineGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {
    @DisplayName("사다리의 라인의 개수가 50개를 초과할 경우 예외가 발생한다.")
    @Test
    void newLadderTestByLineCount() {
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
                .hasMessage("[ERROR] 사다리의 최대 높이는 50이하만 가능합니다.");
    }
}
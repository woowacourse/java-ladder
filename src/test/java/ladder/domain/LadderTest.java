package ladder.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사다리의 라인의 개수가 50개를 초과할 경우 예외가 발생한다.")
    @Test
    void newLadderTestByLineCount() {
        //given
        int lineCount = 51;
        List<Line> lines = new ArrayList<>();
        for (int i = 0; i < lineCount; i++) {
             lines.add(LineGenerator.generate(5));
        }

        //when, then
        assertThatThrownBy(() -> new Ladder(lines))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 사다리의 최대 높이는 50이하만 가능합니다.");
    }

}
package ladder.dto;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Line;
import ladder.domain.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void ofLadder_success() {
        // given
        Ladder ladder = new Ladder(List.of(createLine(), createLine(), createLine()), 3);

        // when
        LadderResponse ladderResponse = LadderResponse.ofLadder(ladder);
        List<String> lines = ladderResponse.getLines();

        // then
        for (String line : lines) {
            assertThat(line)
                    .isEqualTo("|     |-----|     |");
        }
    }

    private static Line createLine() {
        return new Line(List.of(Step.EMPTY, Step.EXIST, Step.EMPTY));
    }

}

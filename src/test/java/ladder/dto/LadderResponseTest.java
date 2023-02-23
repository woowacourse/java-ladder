package ladder.dto;

import static ladder.Util.createLines;
import static ladder.Util.createPlayers;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import ladder.domain.Ladder;
import ladder.domain.Step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResponseTest {

    @Test
    @DisplayName("정상적으로 문자열을 반환해야 한다.")
    void ofLadder_success() {
        // given
        List<Step> steps = List.of(Step.EMPTY, Step.EXIST, Step.EMPTY);
        Ladder ladder = new Ladder(createLines(4, steps), createPlayers(4));

        // when
        LadderResponse ladderResponse = LadderResponse.ofLadder(ladder);
        List<String> lines = ladderResponse.getLines();

        // then
        for (String line : lines) {
            assertThat(line)
                    .isEqualTo("|     |-----|     |");
        }
    }
}

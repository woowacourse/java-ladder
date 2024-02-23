package ladder.dto.response;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.domain.ladder.Ladder;
import ladder.domain.ladder.LadderHeight;
import ladder.domain.ladder.Rung;
import ladder.domain.ladder.generator.RungGenerator;
import ladder.mock.MockRungGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResponseTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        List<Rung> rungs = List.of(Rung.EXIST, Rung.EMPTY);
        RungGenerator rungGenerator = new MockRungGenerator(rungs);
        Ladder ladder = new Ladder(2, new LadderHeight(2), rungGenerator);
        LadderResponse ladderResponse = LadderResponse.from(ladder);

        assertThat(ladderResponse.lineResponses()).containsExactly(
                new LineResponse(List.of(true)),
                new LineResponse(List.of(false))
        );
    }
}

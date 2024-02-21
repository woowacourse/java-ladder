package ladder.dto.response;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.util.List;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderResponseTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        BooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true, false));
        Ladder ladder = new Ladder(2, new Height(2), booleanGenerator);
        LadderResponse ladderResponse = LadderResponse.from(ladder);

        assertThat(ladderResponse.lineResponses()).containsExactly(
                new LineResponse(List.of(true)),
                new LineResponse(List.of(false))
        );
    }
}

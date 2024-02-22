package ladder.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.generator.BooleanGenerator;
import ladder.domain.ladder.Height;
import ladder.domain.ladder.Ladder;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderDtoTest {

    @Test
    @DisplayName("Dto로 변환한다.")
    void toDto() {
        BooleanGenerator booleanGenerator = new MockBooleanGenerator(List.of(true, false));
        Ladder ladder = new Ladder(2, 2, booleanGenerator);
        LadderDto ladderDto = LadderDto.from(ladder);

        assertThat(ladderDto.lineDtos()).containsExactly(
                new LineDto(List.of(true)),
                new LineDto(List.of(false))
        );
    }
}

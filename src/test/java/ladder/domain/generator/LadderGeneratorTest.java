package ladder.domain.generator;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.Height;
import ladder.domain.Ladder;
import ladder.domain.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderGeneratorTest {

    @Test
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        //given
        final var ladderGenerator = new LadderGenerator();
        final Players players = new Players(List.of("pobi", "crong"));
        final Height height = new Height(5);

        //when
        Ladder ladder = ladderGenerator.generate(new LineGenerator(), players, height);

        //then
        assertThat(ladder.getLines()).hasSize(5);
    }
}

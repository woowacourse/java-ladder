package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import ladder.domain.generator.RandomDirectionGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @Test
    @DisplayName("사다리 높이만큼 선을 생성한다.")
    void validLadder() {
        final Players players = new Players(List.of("pobi", "crong"));
        final Height height = new Height(5);

        //when
        final Ladder ladder = Ladder.of(new RandomDirectionGenerator(), players, height);

        //then
        assertThat(ladder.getLines()).hasSize(5);
    }
}

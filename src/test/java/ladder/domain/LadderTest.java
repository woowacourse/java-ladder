package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LadderTest {

    @DisplayName("사람 수와 높이를 입력받아 사다리를 생성한다.")
    @Test
    void ladderSizeTest() {
        Ladder ladder = Ladder.of(
                new Players(List.of("poby", "honux", "crong", "jk")),
                new Height(5),
                new DefaultLadderDirectionSelector());

        List<LadderLevel> ladderLevels = ladder.getLadderLevels();
        List<LadderDirection> ladderDirections = ladderLevels.get(0).getLadderDirections();

        assertAll(
                () -> assertThat(ladderLevels).hasSize(5),
                () -> assertThat(ladderDirections).hasSize(4)
        );
    }
}

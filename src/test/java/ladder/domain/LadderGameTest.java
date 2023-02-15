package ladder.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class LadderGameTest {

    private final List<String> players = List.of("도이", "주노");

    @Test
    void 사다리는_높이_만큼의_라인을_가진다() {
        LadderGame ladderGame = new LadderGame(players);

        assertThat(ladderGame.play(4)).hasSize(4);
    }
}

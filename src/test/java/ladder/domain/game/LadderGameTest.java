package ladder.domain.game;

import ladder.domain.ladder.Ladder;
import ladder.mock.MockBooleanGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;

class LadderGameTest {

    @Test
    @DisplayName("사다리 게임 결과를 알 수 있다.")
    void play() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(4, 1, new MockBooleanGenerator(List.of(true, false, true)));
        LadderGame ladderGame = new LadderGame(ladder, players);

        PlayResult playResult = ladderGame.play();
        Map<String, Integer> result = playResult.getResult();

        assertThat(result).containsExactly(entry("pobi", 1), entry("honux", 0), entry("crong", 3), entry("jk", 2));
    }
}

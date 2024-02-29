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
        Ladder ladder = new Ladder(4, 1, new MockBooleanGenerator(List.of(true, false, true)));
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Prizes prizes = new Prizes(List.of("꽝", "5000", "꽝", "3000"), players.count());

        LadderGame ladderGame = new LadderGame(ladder);

        PlayResult playResult = ladderGame.play(players, prizes);
        Map<String, String> result = playResult.getResult();

        assertThat(result).containsExactly(
                entry("pobi", "5000"), entry("honux", "꽝"), entry("crong", "3000"), entry("jk", "꽝")
        );
    }
}

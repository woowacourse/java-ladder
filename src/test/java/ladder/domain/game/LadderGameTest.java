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
    @DisplayName("사다리 게임에 참여하는 참여자들과 결과에 따른 상품에 대한 정보를 가진다.")
    void createLadderGame() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(4, 1, new MockBooleanGenerator(List.of(true, false, true)));
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        assertThatCode(() -> new LadderGame(ladder, players, prizes))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("참여자들의 수와 상품의 수가 다르면 예외가 발생한다.")
    void invalidLadderGame() {
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        Ladder ladder = new Ladder(4, 1, new MockBooleanGenerator(List.of(true, false, true)));
        List<String> prizes = List.of("꽝", "5000", "꽝");

        assertThatThrownBy(() -> new LadderGame(ladder, players, prizes))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사다리 게임 결과를 알 수 있다.")
    void play() {
        Ladder ladder = new Ladder(4, 1, new MockBooleanGenerator(List.of(true, false, true)));
        Players players = new Players(List.of("pobi", "honux", "crong", "jk"));
        List<String> prizes = List.of("꽝", "5000", "꽝", "3000");

        LadderGame ladderGame = new LadderGame(ladder, players, prizes);

        PlayResult playResult = ladderGame.play();
        Map<String, Integer> result = playResult.getResult();

        assertThat(result).containsExactly(entry("pobi", 1), entry("honux", 0), entry("crong", 3), entry("jk", 2));
    }
}

package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.TestBooleanGenerator;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

class LadderTest {

    @DisplayName("사다리 생성")
    @Test
    void makeLadderTest() {
        Height height = new Height("5");
        TestBooleanGenerator testBooleanGenerator = new TestBooleanGenerator(true);

        assertThatCode(() -> Ladder.of(height, 5, testBooleanGenerator))
                .doesNotThrowAnyException();
    }

    @DisplayName("사다리 게임 진행")
    @Test
    void playLadder() {
        Players players = new Players(List.of("1", "2", "3", "4"));
        Prizes prizes = new Prizes(List.of("꽝", "1000", "2000", "3000"));
        GameResult gameResult = new GameResult();

        Map<Player, String> expected = new HashMap<>();
        expected.put(players.findPlayersByName("1"), prizes.getPrizeByPosition(1));
        expected.put(players.findPlayersByName("2"), prizes.getPrizeByPosition(0));
        expected.put(players.findPlayersByName("3"), prizes.getPrizeByPosition(3));
        expected.put(players.findPlayersByName("4"), prizes.getPrizeByPosition(2));

        Ladder ladder = Ladder.of(new Height("5"), players.getPlayersCount(), new TestBooleanGenerator(true));

        ladder.playLadder(gameResult, prizes, players);
        assertThat(gameResult.getPlayersResult()).isEqualTo(expected);
    }
}

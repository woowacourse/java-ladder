package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @DisplayName("실행 결과는 사용자의 수와 동일하다.")
    @Test
    void checkGameResultSize() {
        assertThatThrownBy(() -> createGame(List.of("pobi", "atom"), List.of("3000")))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("사용자의 위치를 입력하면, 게임 결과를 받아올 수 있다.")
    @Test
    void showResult() {
        Game game = createGame(
                List.of("pobi", "atom", "mang", "jay"),
                List.of("3000", "1000", "2000", "꽝"));

        GameResult result = game.showResult("atom");

        assertThat(result.getName()).isEqualTo("꽝");
    }

    @DisplayName("모든 사용자의 사다리 게임 결과를 조회할 수 있다.")
    @Test
    void showResultAll() {
        Game game = createGame(
                List.of("pobi", "atom", "mang", "jay"),
                List.of("3000", "1000", "2000", "꽝"));

        Map<String, GameResult> result = game.showResultAll();

        assertThat(result.get("pobi")).isEqualTo(new GameResult("3000"));
        assertThat(result.get("atom")).isEqualTo(new GameResult("꽝"));
        assertThat(result.get("mang")).isEqualTo(new GameResult("1000"));
        assertThat(result.get("jay")).isEqualTo(new GameResult("2000"));
    }

    private Game createGame(List<String> playerNames, List<String> gameResults) {
        Players players = new Players(playerNames);
        Ladder ladder = createLadder();

        return new Game(players, ladder, gameResults.stream().map(GameResult::new).toList());
    }

    private Ladder createLadder() {
        List<Stick> sticks = List.of(
                Stick.NOT_FILLED,
                Stick.FILLED,
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.NOT_FILLED,
                Stick.FILLED
        );

        return Ladder.createConfigurableLadder(2, 4, new SimpleStickGenerator(sticks));
    }
}

package laddergame.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameResultTest {
    private List<Player> players = Arrays.asList(new Player(new PlayerName("a")), new Player(new PlayerName("b")), new Player(new PlayerName("c")));
    private List<Prize> prizes = Arrays.asList(new Prize("win"), new Prize("win"), new Prize("lose"));
    private GameResult gameResult;

    @BeforeEach
    void setUp() {
        gameResult = new GameResult(new PlayerResult(players), new PrizeGroup(prizes));
    }

    @Test
    void 리스트에_존재하지않을때_테스트() {
        assertThrows(IllegalArgumentException.class, () -> gameResult.getRequestedPrize(new Player(new PlayerName("JM"))));
    }

    @Test
    void 결과_출력에_특정플레이어를_입력했을때_제대로하는지_테스트() {
        assertThat(gameResult.getRequestedPrize(new Player(new PlayerName("a")))).isEqualTo(new Prize("win"));
        assertThat(gameResult.getRequestedPrize(new Player(new PlayerName("b")))).isEqualTo(new Prize("win"));
    }

    @Test
    void 결과_출력이_all일때_제대로하는지_테스트() {
        Map<Player, Prize> results = new HashMap<>();
        results.put(new Player(new PlayerName("a")), new Prize("win"));
        results.put(new Player(new PlayerName("b")), new Prize("win"));
        results.put(new Player(new PlayerName("c")), new Prize("lose"));

        assertThat(gameResult.getAllResult()).isEqualTo(results);
    }
}

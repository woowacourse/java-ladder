package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.stick.Stick;
import domain.ladder.stick.StickGenerator;
import domain.ladder.sticks.SticksGenerator;
import domain.player.Player;
import domain.player.Players;
import domain.result.Result;
import domain.result.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

class LadderGameTest {

    private LadderGame ladderGame;

    @BeforeEach
    void setUp() {
        int height = 2;
        Players players = new Players(List.of("산초", "아톰"));
        Ladder ladder = new Ladder(new Height(height), players.getPlayerSize(), mockSticksGenerator());
        Results results = new Results(List.of("꽝", "당첨"), players.getPlayerSize());
        ladderGame = new LadderGame(players, ladder, results);
    }

    @DisplayName("사다리 타기 실행 결과를 반환한다.")
    @Nested
    class resultTest {
        @DisplayName("전체 사용자의 사다리 타기 결과를 반환한다.")
        @Test
        void checkAllResult() {
            Map<Player, Result> playerResult = ladderGame.getAllPlayerResults();

            Assertions.assertThat(playerResult.get(new Player("산초"))).isEqualTo(new Result("꽝"));
            Assertions.assertThat(playerResult.get(new Player("아톰"))).isEqualTo(new Result("당첨"));
        }

        @DisplayName("한 사용자의 사다리 타기 결과를 반환한다.")
        @Test
        void checkOneResult() {
            Result result = ladderGame.getOnePlayerResult("산초");

            Assertions.assertThat(result).isEqualTo(new Result("꽝"));
        }
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }
}
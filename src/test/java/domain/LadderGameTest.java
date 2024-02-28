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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class LadderGameTest {

    @DisplayName("사다리 타기를 실행하면, 사용자에 따른 실행 결과가 나온다.")
    @Test
    void create() {
        int height = 2;
        Players players = new Players(List.of("산초", "아톰"));
        Ladder ladder = new Ladder(new Height(height), players.getPlayerSize(), mockSticksGenerator());
        Results results = new Results(List.of("꽝", "당첨"), players.getPlayerSize());
        LadderGame ladderGame = new LadderGame(players, ladder, results);

        Map<Player, Result> playerResult = ladderGame.play(players, ladder, results);

        Player player1 = players.getPlayers().get(0);
        Player player2 = players.getPlayers().get(1);
        Result result1 = results.getResults().get(0);
        Result result2 = results.getResults().get(1);
        assertAll(
                () -> assertEquals(result1, playerResult.get(player1)),
                () -> assertEquals(result2, playerResult.get(player2))
        );
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }
}
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

        Map<Player, Result> playerResult = ladderGame.play();

        assertAll(
                () -> assertEquals("꽝", playerResult.get("산초").getValue()),
                () -> assertEquals("당첨", playerResult.get("아톰").getValue())
        );
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }
}
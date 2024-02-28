package domain;

import domain.ladder.Height;
import domain.ladder.Ladder;
import domain.ladder.stick.Stick;
import domain.ladder.stick.StickGenerator;
import domain.ladder.sticks.SticksGenerator;
import domain.player.Players;
import domain.result.Results;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class LadderGameTest {

    @DisplayName("생성 테스트")
    @Test
    void create() {
        Players players = new Players(List.of("산초, 아톰"));
        Ladder ladder = new Ladder(new Height(1), players.getPlayerSize(), mockSticksGenerator());
        Results results = new Results(List.of("꽝, 당첨"), players.getPlayerSize());

        Assertions.assertThatCode(() -> new LadderGame(players, ladder, results))
                .doesNotThrowAnyException();
    }

    private StickGenerator mockStickGenerator() {
        return () -> Stick.FILLED;
    }

    private SticksGenerator mockSticksGenerator() {
        return (mockStickGenerator) -> List.of(Stick.FILLED, Stick.NOT_FILLED);
    }
}
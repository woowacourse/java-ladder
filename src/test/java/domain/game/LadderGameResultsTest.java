package domain.game;

import domain.ladder.Ladder;
import domain.ladder.LadderHeight;
import domain.player.PlayerNames;
import domain.player.Players;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultsTest {

    @DisplayName("사다리 타기 결과를 생성한다.")
    @Test
    void 사다리_타기_결과_생성() {
        // Given
        LadderHeight ladderHeight = new LadderHeight(5);
        Ladder ladder = Ladder.of(() -> true, ladderHeight, 4);
        Players players = Players.of(PlayerNames.of(List.of("pobi", "honux", "crong", "jk")), ladderHeight);
        GameResults gameResults = GameResults.of(List.of("꽝", "5000", "꽝", "3000"));

        // When
        LadderGameResults ladderGameResults = LadderGameResults.of(ladder, players, gameResults);

        // Then
        assertThat(ladderGameResults).isNotNull();
    }
}

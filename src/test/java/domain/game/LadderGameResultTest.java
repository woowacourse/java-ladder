package domain.game;

import domain.player.PlayerName;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LadderGameResultTest {

    @DisplayName("사용자 이름과 게임 결과를 입력하면 LadderGameResult 인스턴스를 반환한다.")
    @Test
    void LadderGameResult_인스턴스_반환() {
        // Given
        final PlayerName playerName = new PlayerName("kelly");
        final GameResult gameResult = GameResult.of("꽝", 1);

        // When
        final LadderGameResult ladderGameResult = new LadderGameResult(playerName, gameResult);

        // Then
        assertThat(ladderGameResult).isNotNull();
    }

    @DisplayName("입력된 사용자 이름과 일치하면 true를 반환한다.")
    @Test
    void 사용자_이름_일치_여부_반환() {
        // Given
        final LadderGameResult ladderGameResult = new LadderGameResult(new PlayerName("kelly"), GameResult.of("꽝", 1));
        final String inputPlayerName = "kelly";

        // When
        final boolean isEqualName = ladderGameResult.isPlayerName(inputPlayerName);

        // Then
        assertThat(isEqualName).isTrue();
    }
}

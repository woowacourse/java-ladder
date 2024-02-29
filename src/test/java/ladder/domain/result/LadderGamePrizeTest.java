package ladder.domain.result;

import ladder.domain.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

class LadderGamePrizeTest {
    @Test
    @DisplayName("참가자들의 사다리 위치와 입력된 사다리 게임 결과로 개인별 사다리 타기 결과를 산출한다.")
    void determinePersonalGameResultTest() {
        // given
        final LadderGamePrize gameResult = new LadderGamePrize(List.of("꽝", "당첨", "꽝"));
        final Participants participants = new Participants(List.of("mia", "pota", "jojo"));

        // when
        final GameResults gameResults = gameResult.determinePersonalResult(participants);

        // then
        final Map<String, String> gameResultsValues = gameResults.getValues();
        assertAll(
                () -> assertThat(gameResultsValues.get("mia")).isEqualTo("꽝"),
                () -> assertThat(gameResultsValues.get("pota")).isEqualTo("당첨"),
                () -> assertThat(gameResultsValues.get("jojo")).isEqualTo("꽝")
        );
    }
}

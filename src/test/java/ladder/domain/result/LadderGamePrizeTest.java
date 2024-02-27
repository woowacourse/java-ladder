package ladder.domain.result;

import ladder.domain.participant.Participants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGamePrizeTest {
    @Test
    @DisplayName("참가자들의 사다리 위치와 입력된 사다리 게임 결과로 개인별 사다리 타기 결과를 산출한다.")
    void determinePersonalGameResultTest() {
        // given
        final LadderGamePrize gameResult = new LadderGamePrize(List.of("꽝", "당첨", "꽝"));
        final Participants participants = new Participants(List.of("mia", "pota", "jojo"));

        // when
        final GameResults personalGameResults = gameResult.determinePersonalResult(participants);

        // then
        assertThat(personalGameResults.findAll())
                .extracting(PersonalGameResult::getPrize)
                .containsExactly("꽝", "당첨", "꽝");
    }
}

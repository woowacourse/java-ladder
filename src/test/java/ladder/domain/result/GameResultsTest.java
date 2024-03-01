package ladder.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultsTest {
    @Test
    @DisplayName("참가자 이름으로 사다리 게임 결과를 조회한다.")
    void findGameResultByParticipantNameTest() {
        // given
        GameResults gameResults = new GameResults(Map.of("mia", "꽝", "pota", "당첨"));

        // when
        String askedGameResult = gameResults.findByName("mia");

        // then
        assertThat(askedGameResult).isEqualTo("꽝");
    }

    @Test
    @DisplayName("존재하지 않은 참가자 이름으로 사다리 게임 결과를 조회할 경우 예외가 발생한다.")
    void checkExistedParticipantName() {
        // given
        GameResults gameResults = new GameResults(Map.of("mia", "꽝", "pota", "당첨"));

        // when & then
        assertThatThrownBy(
                () -> gameResults.findByName("jojo")
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("존재하지 않는 참가자입니다.");
    }
}

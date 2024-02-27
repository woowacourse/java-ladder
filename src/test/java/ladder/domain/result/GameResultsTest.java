package ladder.domain.result;

import ladder.domain.participant.Participant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class GameResultsTest {
    @Test
    @DisplayName("참가자 이름으로 사다리 게임 결과를 조회한다.")
    void findGameResultByParticipantNameTest() {
        // given
        PersonalGameResult gameResultOfMia = new PersonalGameResult(new Participant("mia", 1), "꽝");
        PersonalGameResult gameResultOfPota = new PersonalGameResult(new Participant("pota", 0), "당첨");
        GameResults gameResults = new GameResults(List.of(gameResultOfMia, gameResultOfPota));

        // when
        String prize = gameResults.findPrizeByName("mia");

        // then
        assertThat(prize).isEqualTo("꽝");
    }

    @Test
    @DisplayName("존재하지 않은 참가자 이름으로 사다리 게임 결과를 조회할 경우 예외가 발생한다.")
    void checkExistedParticipantName() {
        // given
        PersonalGameResult gameResultOfMia = new PersonalGameResult(new Participant("mia", 1), "꽝");
        PersonalGameResult gameResultOfPota = new PersonalGameResult(new Participant("pota", 0), "당첨");
        GameResults gameResults = new GameResults(List.of(gameResultOfMia, gameResultOfPota));

        // when & then
        assertThatThrownBy(
                () -> gameResults.findPrizeByName("jojo")
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("존재하지 않는 참가자입니다.");
    }
}

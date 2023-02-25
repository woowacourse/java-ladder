package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.Map;

import static laddergame.domain.TestFixture.ERROR_MESSAGE_HEAD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LadderGameTest {

    private LadderGame ladderGame;
    private Participants participants;
    private Ladder ladder;
    private Results results;

    @BeforeEach
    void setUp() {
        final String participantNames = "pobi,honux,crong,jk";
        final String resultNames = "1st,2nd,3rd,4th";

        participants = Participants.create(participantNames);
        ladder = Ladder.create(() -> true, "2", 4);
        results = new Results(resultNames, participants.size());

        ladderGame = new LadderGame(participants, ladder, results);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tomy", "토미", "jamie", "제이미"})
    @DisplayName("요청된 내용이 참여자나 요청 키에 포함되지 않으면, 예외가 발생한다.")
    void throws_exception_if_request_content_is_not_included_in_participants_or_request_key(String requestContent) {
        assertThatThrownBy(() -> ladderGame.getResultByRequestContent(requestContent))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1st", "honux:2nd", "crong:3rd", "jk:4th"}, delimiter = ':')
    @DisplayName("참여자 이름을 입력하면, 한 명의 참여자에 대한 실행결과를 얻는다.")
    void gets_result_of_participant_if_request_content_is_included_in_participants(String requestContent, String expectedResult) {
        Map<String, String> resultByRequestContent = ladderGame.getResultByRequestContent(requestContent);

        String actualResult = resultByRequestContent.get(requestContent);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("\"all\"을 입력하면, 모든 참여자에 대한 실행결과를 얻는다.")
    void gets_all_results_if_request_content_is_same_with_all_request_key() {
        String requestAll = "all";
        List<String> participantNames = List.of("pobi", "honux", "crong", "jk");
        List<String> resultNames = List.of("1st", "2nd", "3rd", "4th");
        Map<String, String> resultByRequestContent = ladderGame.getResultByRequestContent(requestAll);

        for (int i = 0; i < resultByRequestContent.size(); i++) {
            String actualResult = resultByRequestContent.get(participantNames.get(i));
            assertThat(actualResult).isEqualTo(resultNames.get(i));
        }
    }
}

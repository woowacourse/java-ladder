package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame ladderGame;
    private Participants participants;

    @BeforeEach
    void setUp() {
        final String participantNames = "pobi,honux,crong,jk";
        final String resultNames = "1st,2nd,3rd,4th";

        participants = Participants.create(participantNames);
        Ladder ladder = Ladder.create(() -> true, "2", 4);
        Results results = new Results(resultNames, participants.size());

        ladderGame = new LadderGame(participants, ladder, results);
    }

    @ParameterizedTest
    @CsvSource(value = {"pobi:1st", "honux:2nd", "crong:3rd", "jk:4th"}, delimiter = ':')
    @DisplayName("참여자 이름을 입력하면, 한 명의 참여자에 대한 실행결과를 얻는다.")
    void gets_result_of_participant_if_request_content_is_included_in_participants(String requestContent, String expectedResult) {
        Participant participant = participants.findParticipant(requestContent);
        UserRequest request = UserRequest.of(requestContent);
        Map<Participant, Result> resultByParticipants = ladderGame.getResultByRequestContent(request);

        Result result = resultByParticipants.get(participant);
        String resultName = result.getResultName();

        assertThat(resultName).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("\"all\"을 입력하면, 모든 참여자에 대한 실행결과를 얻는다.")
    void gets_all_results_if_request_content_is_same_with_all_request_key() {
        List<Participant> allParticipants = participants.getAllParticipants();
        UserRequest request = UserRequest.of("all");

        List<String> resultNames = List.of("1st", "2nd", "3rd", "4th");
        Map<Participant, Result> resultByParticipants = ladderGame.getResultByRequestContent(request);

        for (int i = 0; i < resultByParticipants.size(); i++) {
            Result result = resultByParticipants.get(allParticipants.get(i));
            assertThat(result.getResultName()).isEqualTo(resultNames.get(i));
        }
    }
}

package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;
import laddergame.util.BooleanGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;
import java.util.Map;

import static laddergame.domain.game.UserRequestedParticipants.ALL_PARTICIPANTS_COMMAND;
import static org.assertj.core.api.Assertions.assertThat;

class LadderGameTest {

    private LadderGame ladderGame;
    private Participants participants;

    @BeforeEach
    void setUp() {
        final String participantNames = "one,two,three,four";
        final String resultNames = "1st,2nd,3rd,4th";
        final BooleanGenerator trueBooleanGenerator = () -> true;

        participants = Participants.create(participantNames);
        Ladder orderedLadder = new Ladder(trueBooleanGenerator, "2", 4);
        Results results = new Results(resultNames, participants.size());

        ladderGame = new LadderGame(participants, orderedLadder, results);
    }

    @ParameterizedTest
    @CsvSource(value = {"one:1st", "two:2nd", "three:3rd", "four:4th"}, delimiter = ':')
    @DisplayName("참여자 이름을 입력하면, 한 명의 참여자에 대한 실행결과를 얻는다.")
    void gets_result_of_participant_if_request_content_is_included_in_participants(String requestContent, String expectedResult) {
        UserRequestedParticipants request = UserRequestedParticipants.from(requestContent);

        Map<Participant, Result> resultByParticipants = ladderGame.getResultByParticipants(request);
        String actualResult = getActualResult(requestContent, resultByParticipants);

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    @DisplayName("\"all\"을 입력하면, 모든 참여자에 대한 실행결과를 얻는다.")
    void gets_all_results_if_request_content_is_same_with_all_request_key() {
        List<Participant> allParticipants = participants.getParticipants();
        List<String> resultNames = List.of("1st", "2nd", "3rd", "4th");
        UserRequestedParticipants request = UserRequestedParticipants.from(ALL_PARTICIPANTS_COMMAND);

        Map<Participant, Result> resultByParticipants = ladderGame.getResultByParticipants(request);

        for (int i = 0; i < resultByParticipants.size(); i++) {
            Result result = resultByParticipants.get(allParticipants.get(i));
            assertThat(result.getResultName()).isEqualTo(resultNames.get(i));
        }
    }

    private String getActualResult(final String requestContent, final Map<Participant, Result> resultByParticipants) {
        Participant participant = participants.findParticipant(requestContent);
        Result result = resultByParticipants.get(participant);
        return result.getResultName();
    }
}

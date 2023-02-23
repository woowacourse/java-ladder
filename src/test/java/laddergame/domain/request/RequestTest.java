package laddergame.domain.request;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Results;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static laddergame.domain.TestFixture.ERROR_MESSAGE_HEAD;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class RequestTest {

    private Request request;
    private Participants participants;
    private Ladder ladder;
    private Results results;

    @BeforeEach
    void setUp() {
        final String participantNames = "pobi,honux,crong,jk";
        final String resultNames = "꽝,5000,꽝,3000";

        participants = Participants.create(participantNames);
        ladder = Ladder.create(() -> true, "2", 4);
        results = new Results(resultNames, participants.size());

        request = new Request(participants, ladder, results);
    }

    @ParameterizedTest
    @ValueSource(strings = {"tomy", "토미", "jamie", "제이미"})
    @DisplayName("요청된 내용이 참여자나 요청 키에 포함되지 않으면, 예외가 발생한다.")
    void throws_exception_if_request_content_is_not_included_in_participants_or_request_key(String requestContent) {
        assertThatThrownBy(() -> request.getResultByRequestContent(requestContent))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ERROR_MESSAGE_HEAD);
    }
}

package laddergame.domain.game;

import laddergame.domain.ladder.Ladder;
import laddergame.domain.participant.Participant;
import laddergame.domain.participant.Participants;
import laddergame.domain.result.Result;
import laddergame.domain.result.Results;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    public static final String ALL_PARTICIPANTS_REQUEST_KEY = "all";

    private final Participants participants;
    private final Ladder ladder;
    private final Results results;

    public LadderGame(final Participants participants, final Ladder ladder, final Results results) {
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
    }

    public void playGameOfAllParticipants() {
        List<Participant> players = participants.getParticipants();
        for (Participant player : players) {
            ladder.moveToDestination(player);
        }
    }

    public Map<String, String> getResultByRequestContent(final String requestContent) {
        validateRequestExistence(requestContent);
        Map<String, String> resultByParticipants = new HashMap<>();
        List<Participant> requestedParticipants = participants.findParticipants(requestContent);
        for (Participant requestedParticipant : requestedParticipants) {
            int participantPosition = requestedParticipant.getParticipantPosition();
            Result result = results.getResult(participantPosition);
            resultByParticipants.put(requestedParticipant.getName(), result.getResultName());
        }
        return resultByParticipants;
    }

    private void validateRequestExistence(final String requestContent) {
        if (!requestContent.equals(ALL_PARTICIPANTS_REQUEST_KEY) && !participants.contains(requestContent)) {
            throw new IllegalArgumentException(String.format("[ERROR] %s은 존재하지 않는 이름입니다. 참여자 한 명의 이름 혹은 \"all\"을 입력하세요.", requestContent));
        }
    }
}

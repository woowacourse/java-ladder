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

    public Map<Participant, Result> getResultByRequestContent(final UserRequest request) {
        Map<Participant, Result> resultByParticipants = new HashMap<>();
        if (request.isAllPlayer()) {
            List<Participant> allParticipants = participants.getAllParticipants();
            for (Participant participant : allParticipants) {
                int position = participant.getParticipantPosition();
                resultByParticipants.put(participant, results.getResult(position));
            }
        }
        if (!request.isAllPlayer()) {
            validateParticipantExistence(request);
            String participantName = request.getRequestContent();
            Participant participant = participants.findParticipant(participantName);
            int position = participant.getParticipantPosition();
            resultByParticipants.put(participant, results.getResult(position));
        }
        return resultByParticipants;
    }

    private void validateParticipantExistence(final UserRequest request) {
        String requestContent = request.getRequestContent();
        if (!participants.contains(requestContent)) {
            throw new IllegalArgumentException(String.format("[ERROR] %s은 존재하지 않는 이름입니다. 참여자 한 명의 이름 혹은 \"all\"을 입력하세요.", requestContent));
        }
    }
}

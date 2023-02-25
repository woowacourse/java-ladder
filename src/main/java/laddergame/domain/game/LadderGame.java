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
    private boolean isContinuing;

    public LadderGame(final Participants participants, final Ladder ladder, final Results results) {
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
        this.isContinuing = true;
    }

    public void playGameOfAllParticipants() {
        List<Participant> players = participants.getParticipants();
        for (Participant player : players) {
            ladder.moveToDestination(player);
        }
    }

    public Map<Participant, Result> getResultByParticipants(final UserRequest request) {
        if (request.isAllParticipants()) {
            isContinuing = false;
            return makeResultByAllParticipants();
        }
        isContinuing = true;
        return makeResultByOneParticipant(request);
    }

    private Map<Participant, Result> makeResultByAllParticipants() {
        Map<Participant, Result> resultByParticipants = new HashMap<>();

        List<Participant> allParticipants = participants.getAllParticipants();
        for (Participant participant : allParticipants) {
            resultByParticipants.put(participant, findResult(participant));
        }

        return resultByParticipants;
    }

    private Map<Participant, Result> makeResultByOneParticipant(final UserRequest request) {
        Participant participant = participants.findParticipant(request.getRequestContent());
        return Map.of(participant, findResult(participant));
    }

    private Result findResult(final Participant participant) {
        int position = participant.getParticipantPosition();
        return results.findResult(position);
    }

    public boolean isContinuing() {
        return isContinuing;
    }
}

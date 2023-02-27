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
    private GameStatus gameStatus;

    public LadderGame(final Participants participants, final Ladder ladder, final Results results) {
        this.participants = participants;
        this.ladder = ladder;
        this.results = results;
        this.gameStatus = GameStatus.CONTINUE;
    }

    public void playGameOfAllParticipants() {
        List<Participant> gameParticipants = participants.getParticipants();
        for (Participant participant : gameParticipants) {
            participant.moveToDestination(ladder);
        }
    }

    public Map<Participant, Result> getResultByParticipants(final UserRequestedParticipants request) {
        if (request.isAllParticipants()) {
            gameStatus = GameStatus.END;
            return makeResultByAllParticipants();
        }
        return makeResultByOneParticipant(request);
    }

    private Map<Participant, Result> makeResultByAllParticipants() {
        Map<Participant, Result> resultByParticipants = new HashMap<>();

        List<Participant> allParticipants = participants.getParticipants();
        for (Participant participant : allParticipants) {
            resultByParticipants.put(participant, findResult(participant));
        }

        return resultByParticipants;
    }

    private Map<Participant, Result> makeResultByOneParticipant(final UserRequestedParticipants request) {
        Participant participant = participants.findParticipant(request.getRequestContent());
        return Map.of(participant, findResult(participant));
    }

    private Result findResult(final Participant participant) {
        int position = participant.getParticipantPosition();
        return results.findResult(position);
    }

    public boolean isContinuing() {
        return gameStatus.isContinuing();
    }
}

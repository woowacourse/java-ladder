package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;

    private final Results results;
    private final SequenceSwapper swapper;

    private final Map<Participant, Result> gameResult = new HashMap<>();


    public LadderGame(Participants participants, Results results, Ladder ladder) {
        this.participants = participants;
        this.results = results;
        this.ladder = ladder;
        this.swapper = SequenceSwapper.initialize(participants.getParticipantsNum());
    }

    public void run() {
        this.ladder.readLines(swapper);
        setGameResult();
    }


    private void setGameResult() {
        List<Integer> sequence = this.swapper.getSequence();
        int sequenceSize = sequence.size();
        for (int i = 0; i < sequenceSize; i++) {
            int changedRank = sequence.get(i);
            gameResult.put(participants.get(changedRank), results.get(i));
        }
    }

    public Result getResultFrom(Participant participant) {
        return gameResult.get(participant);
    }

    public Map<Participant, Result> getAllGameResult() {
        return new HashMap<>(gameResult);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public Results getResults() {
        return results;
    }
}

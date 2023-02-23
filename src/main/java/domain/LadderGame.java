package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final int GAP_BETWEEN_PARTICIPANTS_AND_WIDTH = 1;
    private final Participants participants;
    private final Ladder ladder;

    private final Results results;

    private final Map<Participant, Result> gameResult = new HashMap<>();


    public LadderGame(Participants participants, Results results, Ladder ladder) {
        this.participants = participants;
        this.results = results;
        this.ladder = ladder;
    }

    public void run(SequenceSwapper swapper) {
        this.ladder.readLines(swapper);
        setGameResult(swapper.getSequence());
    }

    public Map<Participant, Result> getGameResult() {
        return gameResult;
    }

    private void setGameResult(List<Integer> resultSequence) {
        for (int i : resultSequence) {
            gameResult.put(participants.get(i), results.get(i));
        }
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }
}

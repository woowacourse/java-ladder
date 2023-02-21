package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class GameResult {

    public static final boolean CONNECTED = true;
    private final Ladder ladder;
    private final Participants participants;
    private final LadderResults ladderResults;
    private final Map<String, String> results = new HashMap<>();

    public GameResult(Ladder ladder, Participants participants, LadderResults ladderResults) {
        this.ladder = ladder;
        this.participants = participants;
        this.ladderResults = ladderResults;
        setResults();
    }

    private void setResults() {
        IntStream.range(0, participants.getCount()).forEach((current) -> {
            final String participantName = participants.getNames().get(current);
            results.put(participantName, getGameResult(current));
        });
    }

    private String getGameResult(int current) {
        for (Line line : ladder.getLines()) {
            current += progress(current, line);
        }
        return ladderResults.getResults().get(current);
    }

    private int progress(int current, Line line) {
        if (current == 0) {
            return getNewPosition(false, line.getBlocks().get(current));
        }
        if (current == participants.getCount() - 1) {
            return getNewPosition(line.getBlocks().get(current - 1), false);
        }
        return getNewPosition(line.getBlocks().get(current - 1), line.getBlocks().get(current));
    }

    private int getNewPosition(boolean left, boolean right) {
        if (left == CONNECTED) {
            return -1;
        }
        if (right == CONNECTED) {
            return 1;
        }
        return 0;
    }

    public Map<String, String> getResult() {
        return results;
    }
}

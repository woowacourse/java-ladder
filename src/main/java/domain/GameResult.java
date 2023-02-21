package domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class GameResult {

    private static final int FIRST_BLOCK_POSITION = 0;
    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;
    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
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

    private String getGameResult(int currentPosition) {
        for (Line line : ladder.getLines()) {
            int move = getMove(currentPosition, line.getBlocks());
            currentPosition += move;
        }
        return ladderResults.getResults().get(currentPosition);
    }

    private int getMove(int currentPosition, List<Boolean> blocks) {
        final int lastBlockPosition = participants.getCount() - 1;
        final int prevBlockPosition = currentPosition - 1;
        if (currentPosition == FIRST_BLOCK_POSITION) {
            return decideDirection(DISCONNECTED, blocks.get(currentPosition));
        }
        if (currentPosition == lastBlockPosition) {
            return decideDirection(blocks.get(prevBlockPosition), DISCONNECTED);
        }
        return decideDirection(blocks.get(prevBlockPosition), blocks.get(currentPosition));
    }

    private int decideDirection(boolean left, boolean right) {
        if (left == CONNECTED) {
            return LEFT;
        }
        if (right == CONNECTED) {
            return RIGHT;
        }
        return STAY;
    }

    public Map<String, String> getResult() {
        return results;
    }
}

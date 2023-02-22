package domain;

import exception.domain.NullNameException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameResult {

    private static final int FIRST_BLOCK_POSITION = 0;
    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;
    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
    private final List<Line> lines;
    private final List<String> participantsNames;
    private final List<String> ladderResults;
    private final Map<String, String> results = new HashMap<>();

    public GameResult(LadderGame ladderGame) {
        this.lines = ladderGame.getLines();
        this.participantsNames = ladderGame.getParticipantNames();
        this.ladderResults = ladderGame.getLadderResultNames();
        setResults();
    }

    private void setResults() {
        participantsNames.forEach((participantName) -> {
            final int order = participantsNames.indexOf(participantName);
            results.put(participantName, getGameResult(order));
        });
    }

    private String getGameResult(int currentPosition) {
        for (Line line : lines) {
            int move = getMove(currentPosition, line.getBlocks());
            currentPosition += move;
        }
        return ladderResults.get(currentPosition);
    }

    private int getMove(int currentPosition, List<Boolean> blocks) {
        final int lastBlockPosition = participantsNames.size() - 1;
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

    public String getResultByName(String name) {
        if (name.equals("all")) {
            return name;
        }
        if (results.containsKey(name)) {
            return results.get(name);
        }
        throw new NullNameException();
    }

    public Map<String, String> getResults() {
        return results;
    }
}

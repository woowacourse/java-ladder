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
    public static final String END = "all";
    private final Map<String, String> results;

    private GameResult(Map<String, String> results) {
        this.results = results;
    }

    public static GameResult of(LadderGame ladderGame) {
        Map<String, String> result = getResults(ladderGame);
        return new GameResult(result);
    }

    private static Map<String, String> getResults(LadderGame ladderGame) {
        List<String> participantNames = ladderGame.getParticipantNames();
        Map<String, String> results = new HashMap<>();
        participantNames.forEach((participantName) -> {
            final int order = participantNames.indexOf(participantName);
            results.put(participantName, getGameResult(ladderGame, order));
        });
        return results;
    }

    private static String getGameResult(LadderGame ladderGame, int currentPosition) {
        for (Line line : ladderGame.getLines()) {
            int move = getMove(currentPosition, line.getBlocks());
            currentPosition += move;
        }
        return ladderGame.getLadderResultNames().get(currentPosition);
    }

    private static int getMove(int currentPosition, List<Boolean> blocks) {
        final int lastBlockPosition = blocks.size();
        final int prevBlockPosition = currentPosition - 1;
        if (currentPosition == FIRST_BLOCK_POSITION) {
            return decideDirection(DISCONNECTED, blocks.get(currentPosition));
        }
        if (currentPosition == lastBlockPosition) {
            return decideDirection(blocks.get(prevBlockPosition), DISCONNECTED);
        }
        return decideDirection(blocks.get(prevBlockPosition), blocks.get(currentPosition));
    }

    private static int decideDirection(boolean left, boolean right) {
        if (left == CONNECTED) {
            return LEFT;
        }
        if (right == CONNECTED) {
            return RIGHT;
        }
        return STAY;
    }

    public String getResultByName(String name) {
        if (name.equals(END)) {
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

package domain;

import domain.ladder.Block;
import domain.ladder.LadderResult;
import domain.ladder.Line;
import domain.participants.Participant;
import exception.ladder.GameEndException;
import exception.participants.NullNameException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class GameResult {

    private static final int FIRST_BLOCK_POSITION = 0;
    private static final boolean CONNECTED = true;
    private static final boolean DISCONNECTED = false;
    private static final int LEFT = -1;
    private static final int STAY = 0;
    private static final int RIGHT = 1;
    private final Map<Participant, LadderResult> results;

    private GameResult(Map<Participant, LadderResult> results) {
        this.results = results;
    }

    public static GameResult from(LadderGame ladderGame) {
        Map<Participant, LadderResult> result = makeResults(ladderGame);
        return new GameResult(result);
    }

    private static Map<Participant, LadderResult> makeResults(LadderGame ladderGame) {
        List<Participant> participants = ladderGame.getParticipants();
        Map<Participant, LadderResult> results = new HashMap<>();
        participants.forEach((participant) -> {
            final int order = participants.indexOf(participant);
            results.put(participant, getGameResultByOrder(ladderGame, order));
        });
        return results;
    }

    private static LadderResult getGameResultByOrder(LadderGame ladderGame, int order) {
        for (Line line : ladderGame.getLines()) {
            int move = getMove(order, line.getBlocks());
            order += move;
        }
        return ladderGame.getResults().get(order);
    }

    private static int getMove(int order, List<Block> blocks) {
        final int lastBlockPosition = blocks.size();
        final int prevBlockPosition = order - 1;
        if (order == FIRST_BLOCK_POSITION) {
            return decideDirection(DISCONNECTED, blocks.get(order).isConnected());
        }
        boolean prevBlockConnectStatus = blocks.get(prevBlockPosition).isConnected();
        if (order == lastBlockPosition) {
            return decideDirection(prevBlockConnectStatus, DISCONNECTED);
        }
        return decideDirection(prevBlockConnectStatus, blocks.get(order).isConnected());
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

    public LadderResult getResultByName(final String name) {
        if (name.equals("exit")) {
            throw new GameEndException();
        }
        Optional<Participant> findParticipant = results.keySet()
            .stream()
            .filter((participant) -> participant.getName().equals(name))
            .findFirst();
        if (findParticipant.isEmpty()) {
            throw new NullNameException();
        }
        return results.get(findParticipant.get());
    }


    public Map<Participant, LadderResult> getResults() {
        return results;
    }
}

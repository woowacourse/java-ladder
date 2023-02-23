package domain;

import domain.ladder.Block;
import domain.ladder.LadderPrize;
import domain.ladder.Line;
import domain.participants.Participant;
import exception.ladder.GameEndException;
import exception.participants.NullNameException;
import java.util.LinkedHashMap;
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
    private final Map<Participant, LadderPrize> results;

    private GameResult(Map<Participant, LadderPrize> results) {
        this.results = results;
    }

    public static GameResult from(LadderGame ladderGame) {
        Map<Participant, LadderPrize> result = makeResults(ladderGame);
        return new GameResult(result);
    }

    private static Map<Participant, LadderPrize> makeResults(LadderGame ladderGame) {
        List<Participant> participants = ladderGame.getParticipants();
        Map<Participant, LadderPrize> results = new LinkedHashMap<>();
        participants.forEach((participant) -> {
            final int position = participants.indexOf(participant);
            results.put(participant, getGameResultByPosition(ladderGame, position));
        });
        return results;
    }

    private static LadderPrize getGameResultByPosition(LadderGame ladderGame, int position) {
        for (Line line : ladderGame.getLines()) {
            int move = getMove(position, line.getBlocks());
            position += move;
        }
        return ladderGame.getResults().get(position);
    }

    private static int getMove(int position, List<Block> blocks) {
        final int lastBlockPosition = blocks.size();
        final int prevPosition = position - 1;
        if (position == FIRST_BLOCK_POSITION) {
            return decideDirection(DISCONNECTED, blocks.get(position).isConnected());
        }
        boolean prevBlockConnectStatus = blocks.get(prevPosition).isConnected();
        if (position == lastBlockPosition) {
            return decideDirection(prevBlockConnectStatus, DISCONNECTED);
        }
        return decideDirection(prevBlockConnectStatus, blocks.get(position).isConnected());
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

    public LadderPrize getResultByName(final String name) {
        if (name.equals("exit")) {
            throw new GameEndException();
        }
        Optional<Participant> findParticipant = results.keySet().stream()
            .filter((participant) -> participant.getName().equals(name))
            .findFirst();
        if (findParticipant.isEmpty()) {
            throw new NullNameException();
        }
        return results.get(findParticipant.get());
    }


    public Map<Participant, LadderPrize> getResults() {
        return results;
    }
}

package domain;

import domain.ladder.Block;
import domain.ladder.Ladder;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.ladder.Line;
import domain.participants.Participant;
import domain.participants.Participants;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class LadderGame {

    private static final int FIRST_BLOCK_POSITION = 0;
    private static final boolean DISCONNECTED = false;
    private final Participants participants;
    private final Ladder ladder;
    private final LadderPrizes ladderPrizes;

    private LadderGame(Participants participants, Ladder ladder, LadderPrizes ladderPrizes) {
        this.participants = participants;
        this.ladder = ladder;
        this.ladderPrizes = ladderPrizes;
    }

    public GameResult generateResults() {
        Map<Participant, LadderPrize> results = new LinkedHashMap<>();
        List<Participant> participants = this.participants.getAllParticipants();
        participants.forEach((participant) -> {
            final int position = participants.indexOf(participant);
            results.put(participant, getPrizeByParticipantPosition(position));
        });
        return new GameResult(results);
    }

    private LadderPrize getPrizeByParticipantPosition(int position) {
        for (Line line : ladder.getLines()) {
            Move nextMove = getMove(position, line.getBlocks());
            position = nextMove.newPosition(position);
        }
        return ladderPrizes.getPrizes().get(position);
    }

    private Move getMove(int currentPosition, List<Block> blocks) {
        final int lastBlockPosition = blocks.size();
        final int prevPosition = currentPosition - 1;
        if (currentPosition == FIRST_BLOCK_POSITION) {
            return Move.get(DISCONNECTED, blocks.get(currentPosition).isConnected());
        }
        boolean prevBlockConnectStatus = blocks.get(prevPosition).isConnected();
        if (currentPosition == lastBlockPosition) {
            return Move.get(prevBlockConnectStatus, DISCONNECTED);
        }
        return Move.get(prevBlockConnectStatus, blocks.get(currentPosition).isConnected());
    }

    public List<Participant> getParticipants() {
        return participants.getAllParticipants();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<LadderPrize> getPrizes() {
        return ladderPrizes.getPrizes();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {

        private Participants participants;
        private Ladder ladder;
        private LadderPrizes ladderPrizes;

        public Builder addParticipants(Participants participants) {
            this.participants = participants;
            return this;
        }

        public Builder addLadder(Ladder ladder) {
            this.ladder = ladder;
            return this;
        }

        public Builder addLadderPrizes(LadderPrizes ladderPrizes) {
            this.ladderPrizes = ladderPrizes;
            return this;
        }

        public LadderGame build() {
            return new LadderGame(participants, ladder, ladderPrizes);
        }
    }
}

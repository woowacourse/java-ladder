package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderPrize;
import domain.ladder.LadderPrizes;
import domain.ladder.Line;
import domain.participants.Participant;
import domain.participants.Participants;
import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final LadderPrizes ladderPrizes;

    private LadderGame(Participants participants, Ladder ladder, LadderPrizes ladderPrizes) {
        this.participants = participants;
        this.ladder = ladder;
        this.ladderPrizes = ladderPrizes;
    }

    public List<Participant> getParticipants() {
        return participants.getAllParticipants();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<LadderPrize> getResults() {
        return ladderPrizes.getLadderPrizes();
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

package builder;

import domain.Ladder;
import domain.LadderGame;
import domain.LadderResults;
import domain.Participants;

public class LadderGameBuilder {

    private Participants participants;
    private Ladder ladder;
    private LadderResults ladderResults;

    public LadderGameBuilder addParticipants(Participants participants) {
        this.participants = participants;
        return this;
    }

    public LadderGameBuilder addLadder(Ladder ladder) {
        this.ladder = ladder;
        return this;
    }

    public LadderGameBuilder addLadderResults(LadderResults ladderResults) {
        this.ladderResults = ladderResults;
        return this;
    }

    public LadderGame build() {
        return new LadderGame(this.participants, this.ladder, this.ladderResults);
    }
}

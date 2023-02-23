package builder;

import domain.LadderGame;
import domain.ladder.Ladder;
import domain.ladder.LadderResults;
import domain.participants.Participants;

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
        return new LadderGame(participants, ladder, ladderResults);
    }
}

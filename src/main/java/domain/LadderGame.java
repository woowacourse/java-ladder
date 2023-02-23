package domain;

import domain.ladder.Ladder;
import domain.ladder.LadderResult;
import domain.ladder.LadderResults;
import domain.ladder.Line;
import domain.participants.Participant;
import domain.participants.Participants;
import java.util.List;

public class LadderGame {

    private final Participants participants;
    private final Ladder ladder;
    private final LadderResults ladderResults;

    public LadderGame(Participants participants, Ladder ladder, LadderResults ladderResults) {
        this.participants = participants;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public List<Participant> getParticipants() {
        return participants.getAllParticipants();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<LadderResult> getResults() {
        return ladderResults.getResults();
    }
}

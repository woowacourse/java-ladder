package domain;

import java.util.List;

public class LadderGame {

    private static Participants participants;
    private static Ladder ladder;
    private static LadderResults ladderResults;

    public LadderGame(Participants participants, Ladder ladder, LadderResults ladderResults) {
        this.participants = participants;
        this.ladder = ladder;
        this.ladderResults = ladderResults;
    }

    public List<String> getParticipantNames() {
        return participants.getNames();
    }

    public List<Line> getLines() {
        return ladder.getLines();
    }

    public List<String> getLadderResultNames() {
        return ladderResults.getResultNames();
    }
}

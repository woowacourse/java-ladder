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

    public LadderGame(Participants participants, Ladder ladder, LadderPrizes ladderPrizes) {
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
        return ladderPrizes.getResults();
    }
}

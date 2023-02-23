package domain;

import domain.util.PointGenerator;

public class LadderGame {

    private static final int GAP_BETWEEN_PARTICIPANTS_AND_WIDTH = 1;
    private final Participants participants;
    private final Ladder ladder;


    public LadderGame(Participants participants, LadderHeight height, PointGenerator pointGenerator) {
        this.participants = participants;
        LadderWidth width = new LadderWidth(participants.getParticipantsNum() - GAP_BETWEEN_PARTICIPANTS_AND_WIDTH);
        this.ladder = Ladder.create(height, width, pointGenerator);
    }

    public void run(SequenceSwapper swapper) {
        this.ladder.readLines(swapper);
    }

    public Participants getParticipants() {
        return participants;
    }

    public Ladder getLadder() {
        return ladder;
    }
}

package domain;

import domain.util.Point;
import domain.util.PointGenerator;

import java.util.List;

public class LadderGame {

    private static final int GAP_BETWEEN_PARTICIPANTS_AND_WIDTH = 1;
    private final Participants participants;
    private final Ladder ladder;


    public LadderGame(Participants participants, LadderHeight height) {
        this.participants = participants;
        LadderWidth width = new LadderWidth(participants.getParticipantsNum() - GAP_BETWEEN_PARTICIPANTS_AND_WIDTH);
        this.ladder = Ladder.build(height, width, PointGenerator.getInstance(true));
    }

    public List<String> getParticipantsNames() {
        return participants.getNames();
    }

    public List<List<Point>> getLadderPoints() {
        return ladder.getLadderPoints();
    }
}

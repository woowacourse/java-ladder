package laddergame.model.Ladder;

import java.util.ArrayList;
import java.util.List;

import laddergame.model.Participants;

public class Ladder {
    private final Height height;
    private final List<Line> ladder;

    public Ladder(Height height, Participants participants) {
        this.height = height;
        List<Line> ladder = new ArrayList<>();
        makeLadder(participants.getNumber(), ladder);
        this.ladder = ladder;
    }

    private void makeLadder(int participantsCount, List<Line> ladder) {
        for (int i = 0; i < height.getHeight(); i++) {
            ladder.add(new Line(participantsCount));
        }
    }

    public int getHeight() {
        return height.getHeight();
    }

    public Line get(int i) {
        return ladder.get(i);
    }
}

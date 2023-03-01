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

    public Ladder(Height height, List<Line> lines) {
        this.height = height;
        this.ladder = lines;
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

    public int getParticipantPosition(int participantsPosition) {
        for (int i = 0; i < height.getHeight(); i++) {
            Line line = ladder.get(i);
            participantsPosition = movePosition(participantsPosition, line);
        }
        return participantsPosition;
    }

    private int movePosition(int participantsPosition, Line line) {
        if (participantsPosition < line.getNumber() && line.hasLine(participantsPosition)) {
            return participantsPosition + 1;
        }
        if (participantsPosition > 0 && line.hasLine(participantsPosition - 1)) {
            return participantsPosition - 1;
        }
        return participantsPosition;
    }
}

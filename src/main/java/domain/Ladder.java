package domain;

import util.BooleanGenerator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(Height height, int participantsCount, BooleanGenerator booleanGenerator) {
        List<Line> ladder = new ArrayList<>();

        makeLadder(ladder, height.getHeight(), participantsCount, booleanGenerator);

        return new Ladder(ladder);
    }

    private static void makeLadder(List<Line> ladder, int height, int participantsCount, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(participantsCount);
            line.makeLine(booleanGenerator);

            ladder.add(line);
        }
    }

    public void playLadder(GameResult gameResult, Prizes prizes, Participants participants) {
        for (int initPosition = 0; initPosition < participants.getParticipantsCount(); initPosition++) {
            Participant participant = participants.findParticipantByInitPosition(initPosition);
            int position = getNextPosition(initPosition);

            gameResult.recordParticipantsResult(participant, prizes, position);
        }
    }

    private int getNextPosition(int initPosition) {
        int position = initPosition;

        for (Line line : ladder) {
            position = line.decideNextPosition(position);
        }

        return position;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}

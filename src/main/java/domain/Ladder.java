package domain;

import util.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Ladder {

    private static final Pattern HEIGHT_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");

    private final List<Line> ladder;

    private Ladder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public static Ladder of(String height, int participantsCount, BooleanGenerator booleanGenerator) {
        List<Line> ladder = new ArrayList<>();

        validateHeight(height);
        makeLadder(ladder, Integer.parseInt(height), participantsCount, booleanGenerator);

        return new Ladder(ladder);
    }

    private static void validateHeight(String height) {
        if (height == null || !HEIGHT_FORMAT_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException("사다리의 최대 높이는 자연수여야 합니다.");
        }
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

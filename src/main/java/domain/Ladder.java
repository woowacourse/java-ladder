package domain;

import util.BooleanGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public class Ladder {

    private static final Pattern HEIGHT_FORMAT_REGEX = Pattern.compile("^[1-9][0-9]*$");

    private final int height;
    private final List<Line> ladder;

    public Ladder(String height) {
        validateHeight(height);
        this.height = Integer.parseInt(height);
        this.ladder = new ArrayList<>();
    }

    private void validateHeight(String height) {
        if (height == null || !HEIGHT_FORMAT_REGEX.matcher(height).matches()) {
            throw new IllegalArgumentException("사다리의 최대 높이는 자연수여야 합니다.");
        }
    }

    public List<Line> makeLadder(int columnLength, BooleanGenerator booleanGenerator) {
        for (int i = 0; i < height; i++) {
            Line line = new Line(columnLength);
            line.makeLine(booleanGenerator);

            ladder.add(line);
        }

        return ladder;
    }

    public void playLadder(Results results, Participants participants) {
        for (int initPosition = 0; initPosition < participants.getParticipantsCount(); initPosition++) {
            int position = getLastPosition(initPosition);
            results.recordParticipantsResult(participants.getParticipants().get(initPosition), position);
        }
    }

    public int getLastPosition(int initPosition) {
        int position = initPosition;

        for (int i = 0; i < height; i++) {
            position = ladder.get(i).decideNextPosition(position);
        }

        return position;
    }

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}

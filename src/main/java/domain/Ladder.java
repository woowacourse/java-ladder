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

    public List<Line> getLadder() {
        return Collections.unmodifiableList(ladder);
    }
}

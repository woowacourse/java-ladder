package ladder.domain;

import java.util.ArrayList;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    Ladder(int heightValue, Line... lines) {
        this(heightValue, Arrays.asList(lines));
    }

    public Ladder(int heightValue, List<Line> lines) {
        validate(heightValue, lines);
        this.lines = new ArrayList<>(lines);
    }

    private void validate(int heightValue, List<Line> lines) {
        validateHeight(heightValue, lines);
    }

    private void validateHeight(int height, List<Line> lines) {
        if (height != lines.size()) {
            throw new IllegalArgumentException("사다리 높이가 최대 사다리 높이와 같아야 합니다.");
        }
    }

    public Index climb(Index index) {
        for (Line line : lines) {
            index = line.move(index);
        }
        return index;
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(lines);
    }
}

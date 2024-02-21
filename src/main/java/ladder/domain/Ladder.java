package ladder.domain;

import java.util.List;

public class Ladder {

    List<Line> lines;

    public Ladder(int peopleCount, int height) {
        validate(peopleCount);
        validate(height);
    }

    private void validate(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("높이가 자연수가 아닙니다.");
        }
    }
}

package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    List<Line> lines;

    public Ladder(int peopleCount, int height) {
        validate(peopleCount);
        validate(height);
        lines = new ArrayList<>();
        LineGenerator lineGenerator = new DefaultLineGenerator();
        for (int i = 0; i < height; i++) {
            lines.add(new Line(peopleCount, lineGenerator));
        }
    }

    private void validate(int number) {
        if (number <= 0) {
            throw new IllegalArgumentException("자연수가 아닙니다.");
        }
    }
}

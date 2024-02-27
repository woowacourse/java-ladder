package domain;

import java.util.Collections;
import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Ladder{

    private final List<Line> ladder;
    private final Height height;

    public Ladder(Height height) {
        validateHeight(height);
        this.height = height;
        this.ladder = new ArrayList<>();
    }

    public void init(int personCount, Generator generator) {
        for (int index = 0; index < height.getHeight(); ++index) {
            ladder.add(index, new Line(generator.generate(personCount)));
        }
    }

    private void validateHeight(Height height) {
        if (height.getHeight() < 1 || height.getHeight() > 50) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 50 이하여야 합니다.");
        }
    }

    public List<Line> getLines() {
        return Collections.unmodifiableList(this.ladder);
    }
}

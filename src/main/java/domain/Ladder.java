package domain;

import util.Generator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> ladder;

    public Ladder(int height) {
        validateHeight(height);
        this.ladder = new ArrayList<>(height);
    }

    public void init(int personCount, Generator generator) {
        ladder.replaceAll(ignored -> new Line(generator.generate(personCount)));
    }

    private void validateHeight(int height) {
        if (height < 1 || height > 50) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 50 이하여야 합니다.");
        }
    }
}

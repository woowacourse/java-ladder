package domain;

import util.Generator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ladder implements Iterable<Line> {

    private final List<Line> ladder;
    private final int height;

    public Ladder(int height) {
        validateHeight(height);
        this.height = height;
        this.ladder = new ArrayList<>();
    }

    public void init(int personCount, Generator generator) {
        for (int index = 0; index < height; ++index) {
            ladder.add(index, new Line(generator.generate(personCount)));
        }
    }

    @Override
    public Iterator<Line> iterator() {
        return ladder.iterator();
    }

    private void validateHeight(int height) {
        if (height < 1 || height > 50) {
            throw new IllegalArgumentException("사다리의 높이는 1 이상 50 이하여야 합니다.");
        }
    }
}

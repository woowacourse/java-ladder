package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();

    public Ladder() {
    }

    public Ladder(int maxHeight, int personCount) {
        IntStream.range(0, maxHeight)
                .forEach(iterator -> ladder.add(new Line(personCount, new RandomGenerator())));
    }

    public List<Line> getLadder() {
        return ladder;
    }

    public int getHeight() {
        return ladder.size();
    }
}

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Ladder {
    private List<Line> ladder = new ArrayList<>();
    private int personCount;
    private int maxHeight;

    public Ladder() {
    }

    public Ladder(int personCount, int maxHeight) {
        this.personCount = personCount;
        this.maxHeight = maxHeight;
    }


    public void generate() {
        IntStream.range(0, maxHeight)
                .forEach(iterator -> ladder.add(new Line(personCount)));
    }

    public int getPersonCount() {
        return personCount;
    }

    public int getMaxHeight() {
        return maxHeight;
    }
}

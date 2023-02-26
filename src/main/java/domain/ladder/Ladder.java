package domain.ladder;

import java.util.ArrayList;
import java.util.List;
import utils.RandomNumberGenerator;

public class Ladder {
    private final List<Line> lines;

    public Ladder(int personCount, int height) {
        RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();
        lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount, randomNumberGenerator));
        }
    }

    public List<Line> getLines() {
        return lines;
    }
}

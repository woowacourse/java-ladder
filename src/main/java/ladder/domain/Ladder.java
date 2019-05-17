package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        for (int i = 0; i < height; ++i) {
            lines.add(new Line(countOfPerson));
        }
    }

    public int getLastPosition(int playerPosition) {
        int lastPosition = playerPosition;

        for (Line line : lines) {
            lastPosition = line.getNextPositon(lastPosition);
        }

        return lastPosition;
    }
}

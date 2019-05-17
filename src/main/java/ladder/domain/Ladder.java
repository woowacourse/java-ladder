package ladder.domain;

import java.util.ArrayList;
import java.util.List;

public class Ladder {
    private final List<Line> lines = new ArrayList<>();

    public Ladder(int countOfPerson, int height) {
        LineGenerator lineGenerator = new LineGenerator(countOfPerson);

        if(countOfPerson <= 0 || height <= 0) {
            throw new IllegalArgumentException(UserOutput.VIOLATE_PLAYER_NAME.getOutputMessage());
        }

        for (int i = 0; i < height; i++) {
            lines.add(lineGenerator.createLine());
        }
    }

    public int getLastPosition(int playerPosition) {
        int lastPosition = playerPosition;

        for (Line line : lines) {
            lastPosition = line.getNextPositon(lastPosition);
        }

        return lastPosition;
    }

    public List<Line> getLines() {
        return this.lines;
    }
}

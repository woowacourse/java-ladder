package ladder.domain.ladder;

import ladder.domain.RandomGenerator;
import ladder.domain.ladderGame.Position;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private final List<Direction> line;

    public Line(final int widthOfLine, RandomGenerator randomBooleanGenerator) {
        this.line = createLine(widthOfLine, randomBooleanGenerator);
    }

    private List<Direction> createLine(int widthOfLine, RandomGenerator randomBooleanGenerator) {
        List<Direction> line = new ArrayList<>();
        Direction previous = Direction.STAY;

        for(int i=0; i<widthOfLine-1 ; i++) {
            Direction newDirection = previous.next(randomBooleanGenerator);
            line.add(newDirection);
            previous = newDirection;
        }
        line.add(previous.last());

        return line;
    }

    public Position findNextPosition(Position position) {
        int current = position.getValue();

        return line.get(current).move(position);
    }


    public List<Direction> getLine() {
        return Collections.unmodifiableList(line);
    }


}

package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Ladder {

    private static final int MIN_HEIGHT = 1;

    static final String INVALID_HEIGHT_ERROR = "[ERROR] 사다리 높이는 1이상이어야 합니다.";

    private final List<Line> lines = new ArrayList<>();

    public Ladder(int height, int playerCount, RandomGenerator generator) {
        validateHeight(height);
        addLine(height, playerCount, generator);
    }

    private void addLine(int height, int playerCount, RandomGenerator generator) {
        for (int i = 0; i < height; i++) {
            lines.add(new Line(playerCount, generator));
        }
    }

    private void validateHeight(int height) {
        if (height < MIN_HEIGHT) {
            throw new IllegalArgumentException(INVALID_HEIGHT_ERROR);
        }
    }

    public int getLastPosition(int position) {
        for (Line line : lines) {
            Direction direction = line.getDirection(position);

            position = move(position, direction);
        }
        return position;
    }

    private int move(int position, Direction direction) {
        if (direction.isLeft()) {
            position--;
        }
        if (direction.isRight()){
            position++;
        }
        return position;
    }

    public List<Integer> getLastPositions(int playerSize) {
        return IntStream.range(0, playerSize)
                .map(this::getLastPosition)
                .boxed()
                .collect(Collectors.toList());
    }

    public List<Line> getLines() {
        return lines;
    }
}

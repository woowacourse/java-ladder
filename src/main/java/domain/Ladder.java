package domain;

import util.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private final List<Line> lines;

    private Ladder(int height, int width, LineGenerator lineGenerator) {
        lines = makeLines(new Height(height), new Width(width), lineGenerator);
    }

    public static Ladder from(int height, int width, LineGenerator lineGenerator) {
        return new Ladder(height, width, lineGenerator);
    }

    private List<Line> makeLines(Height height, Width width, LineGenerator lineGenerator) {
        List<Line> newlines = new ArrayList<>();
        for (int i = 0; i < height.getHeight(); i++) {
            newlines.add(Line.of(width.getWidth(), lineGenerator));
        }
        return newlines;
    }

    public Position climb(Position playerPosition) {
        for (Line line : lines) {
            playerPosition = movePosition(playerPosition, line);
        }
        return playerPosition;
    }

    private Position movePosition(Position playerPosition, Line line) {
        if (!isFarLeft(playerPosition) && isLegLeftExist(playerPosition, line)) {
            return playerPosition.decrease();
        }
        if (!isFarRight(playerPosition, line) && isLegRightExist(playerPosition, line)) {
            return playerPosition.increase();
        }
        return playerPosition;
    }
    private boolean isFarLeft(Position playerPosition) {
        return playerPosition.getIndex() == 0;
    }

    private boolean isFarRight(Position playerPosition, Line line) {
        return playerPosition.getIndex() == line.getLegs().size();
    }

    private boolean isLegRightExist(Position playerPosition, Line line) {
        return line.getLegs().get(playerPosition.getIndex()).isExist();
    }

    private boolean isLegLeftExist(Position playerIndex, Line line) {
        return line.getLegs().get(playerIndex.getIndex() - 1).isExist();
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}

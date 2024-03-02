package domain;

import util.generator.LineGenerator;

import java.util.ArrayList;
import java.util.List;

public class Ladder {

    private static final int FAR_LEFT_POSITION = 0;

    private final List<Line> lines;

    private Ladder(int height, int width, LineGenerator lineGenerator) {
        lines = makeLines(new Height(height), new Width(width), lineGenerator);
    }

    public static Ladder of(int height, int width, LineGenerator lineGenerator) {
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
        if (isNotFarLeft(playerPosition) && isLegLeftExist(playerPosition, line)) {
            return playerPosition.decrease();
        }
        if (isNotFarRight(playerPosition, line) && isLegRightExist(playerPosition, line)) {
            return playerPosition.increase();
        }
        return playerPosition;
    }

    private boolean isNotFarLeft(Position playerPosition) {
        return playerPosition.getIndex() != FAR_LEFT_POSITION;
    }

    private boolean isNotFarRight(Position playerPosition, Line line) {
        return playerPosition.getIndex() != line.getFarRightPosition().getIndex();
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

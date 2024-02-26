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

    public int climb(int playerIndex) {
        for (Line line : lines) {
            playerIndex = movePosition(playerIndex, line);
        }
        return playerIndex;
    }

    private int movePosition(int playerIndex, Line line) {
        if (!isFarLeft(playerIndex) && isLegLeftExist(playerIndex, line)) {
            return playerIndex - 1;
        }
        if (!isFarRight(playerIndex, line) && isLegRightExist(playerIndex, line)) {
            return playerIndex + 1;
        }
        return playerIndex;
    }

    private boolean isFarLeft(int playerIndex) {
        return playerIndex == 0;
    }

    private boolean isFarRight(int playerIndex, Line line) {
        return playerIndex == line.getLegs().size();
    }

    private boolean isLegRightExist(int playerIndex, Line line) {
        return line.getLegs().get(playerIndex).isExist();
    }

    private boolean isLegLeftExist(int playerIndex, Line line) {
        return line.getLegs().get(playerIndex - 1).isExist();
    }

    public List<Line> getLines() {
        return List.copyOf(lines);
    }
}

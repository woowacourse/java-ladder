package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.NumberGenerator;

public class Ladder {

    private final List<Line> lines;
    private final LadderHeight ladderHeight;

    private Ladder(List<Line> lines, LadderHeight ladderHeight) {
        this.lines = lines;
        this.ladderHeight = ladderHeight;
    }

    public static Ladder of(int numberOfPeople,
                            LadderHeight ladderHeight,
                            NumberGenerator numberGenerator) {
        List<Line> lines = new ArrayList<>();
        Ladder ladder = new Ladder(lines, ladderHeight);
        ladder.addLines(numberOfPeople, numberGenerator);
        return ladder;
    }

    private void addLines(int numberOfPeople, NumberGenerator numberGenerator) {
        for (int i = 0; i < height(); i++) {
            lines.add(Line.create(numberOfPeople, numberGenerator));
        }
        if (isLadderNotConnected(numberOfPeople)) {
            lines.clear();
            addLines(numberOfPeople, numberGenerator);
        }
    }

    private boolean isLadderNotConnected(int numberOfPeople) {
        Boolean[] isConnectedAt = getLadderConnectionStatus(numberOfPeople);
        return Arrays.stream(isConnectedAt)
                .collect(Collectors.toSet())
                .size() != 1;
    }

    private Boolean[] getLadderConnectionStatus(int numberOfPeople) {
        int lineWidth = numberOfPeople - 1;
        Boolean[] isConnectedAt = new Boolean[lineWidth];
        Arrays.fill(isConnectedAt, false);
        lines.forEach(line -> getLineConnectionStatus(isConnectedAt, line));
        return isConnectedAt;
    }

    private void getLineConnectionStatus(Boolean[] isConnectedAt, Line line) {
        for (int i = 0; i < line.points().size(); i++) {
            getPointConnectionStatus(isConnectedAt, line, i);
        }
    }

    private void getPointConnectionStatus(Boolean[] isConnectedAt, Line line, int i) {
        if (line.points().get(i).isPassable()) {
            isConnectedAt[i] = true;
        }
    }

    public int getResultPositionOf(int startPosition) {
        int horizontalPosition = startPosition;
        for (Line line : lines) {
            horizontalPosition = getNextLineHorizontalPosition(line, horizontalPosition);
        }
        return horizontalPosition;
    }

    private int getNextLineHorizontalPosition(Line line, int horizontalPosition) {
        if (isRightPassable(line, horizontalPosition)) {
            return horizontalPosition + 1;
        }
        if (isLeftPassable(line, horizontalPosition)) {
            return horizontalPosition - 1;
        }
        return horizontalPosition;
    }

    private boolean isRightPassable(Line line, int horizontalPosition) {
        if (horizontalPosition == line.width()) {
            return false;
        }
        return line.points().get(horizontalPosition).isPassable();
    }

    private boolean isLeftPassable(Line line, int horizontalPosition) {
        if (horizontalPosition == 0) {
            return false;
        }
        return line.points().get(horizontalPosition - 1).isPassable();
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }

    public int height() {
        return ladderHeight.value();
    }
}

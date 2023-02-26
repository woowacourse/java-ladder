package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import utils.NumberGenerator;

public class Ladder {

    public static final int LEFTMOST_POSITION = 0;
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
        for (int i = 0; i < line.width(); i++) {
            getPointConnectionStatus(isConnectedAt, line, i);
        }
    }

    private void getPointConnectionStatus(Boolean[] isConnectedAt, Line line, int i) {
        if (line.points().get(i).isPassable()) {
            isConnectedAt[i] = true;
        }
    }

    public int getResultPositionOf(int startPosition) {
        Position position = new Position(startPosition);
        for (Line line : lines) {
            moveToNextLine(line, position);
        }
        return position.value();
    }

    private void moveToNextLine(Line line, Position position) {
        if (isRightPassable(line, position.value())) {
            position.moveToRight();
            return;
        }
        if (isLeftPassable(line, position.value())) {
            position.moveToLeft();
        }
    }

    private boolean isRightPassable(Line line, int position) {
        if (position == line.width()) {
            return false;
        }
        return line.points().get(position).isPassable();
    }

    private boolean isLeftPassable(Line line, int position) {
        if (position == LEFTMOST_POSITION) {
            return false;
        }
        return line.points().get(position - 1).isPassable();
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }

    public int height() {
        return ladderHeight.value();
    }

    public List<Line> getValues() {
        return List.copyOf(lines);
    }
}

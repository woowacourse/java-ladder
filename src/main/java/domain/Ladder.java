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
        for (int i = 0; i < line.width(); i++) {
            getPointConnectionStatus(isConnectedAt, line, i);
        }
    }

    private void getPointConnectionStatus(Boolean[] isConnectedAt, Line line, int i) {
        if (line.points().get(i).isPassable()) {
            isConnectedAt[i] = true;
        }
    }

    public Position getResultPositionOf(Position position) {
        for (Line line : lines) {
            line.tryMoveAt(position);
        }
        return position;
    }

    public List<Line> lines() {
        return List.copyOf(lines);
    }

    public int height() {
        return ladderHeight.value();
    }

}

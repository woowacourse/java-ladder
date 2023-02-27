package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lines {

    private static final int MINIMUM_LADDER_HEIGHT = 1;
    private static final String VALIDATE_LADDER_HEIGHT_MESSAGE = "사다리의 최소 높이는 " + MINIMUM_LADDER_HEIGHT + " 이상이어야 합니다.";

    private final List<Line> lines;

    public Lines(int personCount, int height) {
        validateLadderHeight(height);
        this.lines = createLines(personCount, height);
    }

    private void validateLadderHeight(int height) {
        if (height < 1) {
            throw new IllegalArgumentException(VALIDATE_LADDER_HEIGHT_MESSAGE);
        }
    }

    public List<Line> getLines() {
        return lines;
    }

    public int getLineHeight() {
        return lines.size();
    }

    private List<Line> createLines(int personCount, int height) {
        List<Line> lines = new ArrayList<>();
        while (height-- > 0) {
            lines.add(new Line(personCount));
        }
        return lines;
    }

    public int calculateResults(int playerPosition) {
        for (Line line : lines) {
            playerPosition = calculateNewPosition(playerPosition, line);
        }
        return playerPosition;
    }

    private int calculateNewPosition(int playerPosition, Line line) {
        if (isRightMovable(playerPosition, line)) {
            return playerPosition + 1;
        }
        if (isLeftMovable(playerPosition, line)) {
            return playerPosition - 1;
        }
        return playerPosition;
    }

    private boolean isRightMovable(int playerPosition, Line line) {
        return playerPosition != line.getSize() && line.isRightMovable(playerPosition);
    }

    private boolean isLeftMovable(int playerPosition, Line line) {
        return playerPosition != 0 && line.isLeftMovable(playerPosition);
    }
}

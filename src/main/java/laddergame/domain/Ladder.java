package laddergame.domain;

import java.util.Optional;

public class Ladder {
    private static final String LADDER_LINES_NULL_EXCEPTION = "Lines는 null이 될 수 없습니다.";

    private final Lines lines;

    public Ladder(final Lines inputLines) {
        this.lines = getLines(inputLines);
    }

    public Position findLastDestination(final Position row) {
        final Height height = lines.getHeight();
        Position participantRow = row;
        for (int column = 0; column < height.getValue(); column++) {
            final Position currentColumn = new Position(column);
            participantRow = findNextPosition(currentColumn, participantRow);
        }
        return participantRow;
    }

    public Lines getLines() {
        return lines;
    }

    private Position findNextPosition(final Position column, final Position row) {
        final Width width = lines.getLines().get(column.getValue()).getWidth();
        final Position maxPosition = new Position(width.getValue());
        final Position leftPosition = row.move(-1);
        if (checkRange(leftPosition, maxPosition) && checkFilled(column, leftPosition)) {
            return row.move(-1);
        }
        if (checkRange(row, maxPosition) && checkFilled(column, row)) {
            return row.move(1);
        }
        return row;
    }

    private boolean checkRange(final Position position, final Position maxPosition) {
        return 0 <= position.getValue() && position.getValue() < maxPosition.getValue();
    }

    private boolean checkFilled(final Position column, final Position row) {
        final int height = lines.getHeight().getValue();
        if (height <= column.getValue()) {
            return false;
        }
        return lines.getPointByColumnAndRow(column, row);
    }

    private Lines getLines(final Lines inputLines) {
        return Optional.ofNullable(inputLines)
                .orElseThrow(() -> new IllegalArgumentException(LADDER_LINES_NULL_EXCEPTION));
    }
}
